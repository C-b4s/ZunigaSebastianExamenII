package ZSDataAccessComponent.ZSHelpers;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ZSDataAccessComponent.ZSInterfaces.IZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppConfig;
import ZSInfrastructureComponent.ZSAppException;  
    
public class ZSDataHelperSQLiteDAO<T> implements IZSDataHelperSQLiteDAO<T>{
    protected final Class<T> zsDTOClass;
    protected final String  zsTableName;
    protected final String  zsTablePK;

    private static final String ZSDBPath = ZSAppConfig.zsGETDATABASE(); 
    private static Connection zsConn = null;

    protected static synchronized Connection zsOpenConnection() throws SQLException {
        if (zsConn == null || zsConn.isClosed()) {
            zsConn = DriverManager.getConnection(ZSDBPath);
        }
        return zsConn;
    }

    protected static void zsCloseConnection() throws SQLException {
        if (zsConn != null && !zsConn.isClosed()) {
            zsConn.close();
        }
    }

    protected String zsGetDateTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Construye la relacion entre la clase ZSDTO y la tabla de la base de datos
     * @param ZSDtoClass : Nombre de la clase ZSDTO
     * @param zsTableName : Nombre de la tabla
     * @param zsTablePK : Nombre del PK de la tabla
     * @throws ZSAppException : Error al asociar la clase con la tabla
     */
    public ZSDataHelperSQLiteDAO(Class<T> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        try {
            zsOpenConnection();
        } catch (SQLException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "ZSDataHelperSQLiteDAO");
        }
        this.zsDTOClass  = ZSDtoClass;
        this.zsTableName = zsTableName;
        this.zsTablePK   = zsTablePK;
    }

    @Override
    public boolean zsCreate(Object zsEntity) throws 
        ZSAppException {
        Field[] zsFields = zsDTOClass.getDeclaredFields();
        StringBuilder zsColumns = new StringBuilder();
        StringBuilder zsPlaceHolders = new StringBuilder();

        for (Field zsField : zsFields) {
            zsField.setAccessible(true);
            String zsName = zsField.getName();
            // Excluir PK y campos por defecto y auditoria
            if (!zsName.equalsIgnoreCase(zsTablePK)
                && !zsName.equalsIgnoreCase("zsEstado")
                && !zsName.equalsIgnoreCase("zsFechaCreacion")
                && !zsName.equalsIgnoreCase("zsFechaModifica")) {
                zsColumns.append(zsName).append(",");
                zsPlaceHolders.append("?,");
            }
        }
        String zsCols = zsColumns.substring(0, zsColumns.length() - 1);
        String zsVals = zsPlaceHolders.substring(0, zsPlaceHolders.length() - 1);

        String zsSql = String.format("INSERT INTO %s (%s) VALUES (%s)", zsTableName, zsCols, zsVals);

        try (PreparedStatement zsStmt= zsOpenConnection().prepareStatement(zsSql)) {
            int index = 1;
            for (Field zsField : zsFields) {
                String zsName = zsField.getName();
                if (!zsName.equalsIgnoreCase(zsTablePK)
                    && !zsName.equalsIgnoreCase("zsEstado")
                    && !zsName.equalsIgnoreCase("zsFechaCreacion")
                    && !zsName.equalsIgnoreCase("zsFechaModifica")) 
                        zsStmt.setObject(index++, zsField.get(zsEntity));
            }
            return (zsStmt.executeUpdate() > 0);
        } catch (SQLException | IllegalAccessException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "zsCreate");
        }
    }

    @Override
    public boolean zsUpdate(Object zsEntity) throws ZSAppException {
        try {
            Field[] zsFields = zsDTOClass.getDeclaredFields();
            StringBuilder zsUpdates = new StringBuilder();
            Object zsPkValue = null;

            for (Field zsField : zsFields) {
                String zsName = zsField.getName();

                if (!zsName.equalsIgnoreCase(zsTablePK)) {
                    zsUpdates.append(zsName).append(" = ?, ");
                } else {
                    if (!zsField.canAccess(zsEntity)) {
                        zsField.setAccessible(true);
                    }
                    zsPkValue = zsField.get(zsEntity);
                }
            }

            zsUpdates.append("ZSFechaModificacion = ?"); // campo técnico de auditóría

            String zsSql = String.format("UPDATE %s SET %s WHERE %s = ?", zsTableName, zsUpdates, zsTablePK);

            try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
                int zsIndex = 1;
                for (Field zsField : zsFields) {
                    String zsName = zsField.getName();
                    if (!zsName.equalsIgnoreCase(zsTablePK)) {
                        if (!zsField.canAccess(zsEntity)) {
                            zsField.setAccessible(true);
                        }
                        zsStmt.setObject(zsIndex++, zsField.get(zsEntity));
                    }
                }

                zsStmt.setString(zsIndex++, zsGetDateTimeNow()); // FechaModifica
                zsStmt.setObject(zsIndex, zsPkValue); // WHERE PK = ?

                return zsStmt.executeUpdate() > 0;
            }

        }   catch (SQLException | IllegalAccessException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "zsUpdate");
        }
    }

    @Override
    public boolean zsDelete(Integer id) throws ZSAppException {
        String zsSql = String.format("UPDATE %s SET ZSEstado = ?, ZSFechaModificacion = ? WHERE %s = ?", zsTableName, zsTablePK);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            zsStmt.setString(1, "X");
            zsStmt.setString(2, zsGetDateTimeNow());
            zsStmt.setInt   (3, id);
            return zsStmt.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new ZSAppException(e.getMessage(), e, getClass(), "zsDelete");
        }
    }


    @Override
    public List<T> zsReadAll() throws ZSAppException {
        List<T> zsList = new ArrayList<>();
        String zsSql = String.format("SELECT * FROM %s WHERE zsEstado = 'A'", zsTableName);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql);
             ResultSet zsRs = zsStmt.executeQuery()) {
            while (zsRs.next()) {
                zsList.add(zsMapResultSetToEntity(zsRs));
            }
        } catch (SQLException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "zsReadAll");
        }
        return zsList;
    }

    @Override
    public T zsReadBy(Integer id) throws ZSAppException {
        String zsSql = String.format("SELECT * FROM %s WHERE %s = ? AND zsEstado = 'A'", zsTableName, zsTablePK);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            zsStmt.setInt(1, id);
            try (ResultSet zsRs = zsStmt.executeQuery()) {
                return zsRs.next() ? zsMapResultSetToEntity(zsRs) : null;
            }
        }catch (SQLException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "zsReadBy");
        }
    }
    
    @Override
    public Integer zsGetMaxReg(String zsTableCellName) throws ZSAppException {
        String zsSql = String.format("SELECT MAX(%s) FROM %s WHERE zsEstado = 'A'", zsTableCellName, zsTableName);
        try (PreparedStatement stmt = zsOpenConnection().prepareStatement(zsSql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new ZSAppException(null, e, getClass(), "getMaxReg(...)");
        }
    }

    @Override
    public Integer zsGetMinReg(String zsTableCellName) throws ZSAppException {
        String zsSql = String.format("SELECT MIN(%s) FROM %s WHERE zsEstado = 'A'", zsTableCellName, zsTableName);
        try (PreparedStatement stmt = zsOpenConnection().prepareStatement(zsSql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new ZSAppException(null, e, getClass(), "getMinReg(...)");
        }
    }

    @Override
    public Integer zsGetCountReg() throws ZSAppException {
        String zsSql = String.format("SELECT COUNT(*) FROM %s WHERE zsEstado = 'A'", zsTableName);
        try (PreparedStatement stmt = zsOpenConnection().prepareStatement(zsSql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new ZSAppException(null, e, getClass(), "getCountReg(...)");
        }
    }

    protected T zsMapResultSetToEntity(ResultSet zsRs) throws ZSAppException {
        try {
            T zsInstance = zsDTOClass.getDeclaredConstructor().newInstance();
            ResultSetMetaData zsMeta = zsRs.getMetaData();

            for (int i = 1; i <= zsMeta.getColumnCount(); i++) {
                String zsCol = zsMeta.getColumnLabel(i); // usa alias si existen
                Object zsVal = zsRs.getObject(i);

                Field zsField = zsDTOClass.getDeclaredField(zsCol);
                if (!zsField.canAccess(zsInstance)) {
                    zsField.setAccessible(true);
                }
                zsField.set(zsInstance, zsVal);
            }
            return zsInstance;
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            throw new ZSAppException(e.getMessage(),e, getClass(), "zsMapResultSetToEntity");
        }
    }
}
