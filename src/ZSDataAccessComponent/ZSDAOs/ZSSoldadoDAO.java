package ZSDataAccessComponent.ZSDAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSSoldadoDAO extends ZSDataHelperSQLiteDAO<ZSSoldadoDTO>{

    public ZSSoldadoDAO(Class<ZSSoldadoDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSSoldadoDTO.class, "ZSSoldado", "IdZSSoldado");
    }

    public ZSSoldadoDTO zsCheck(String usuario, String contrasena) throws ZSAppException {

    String zsSql = String.format(
        "SELECT * FROM %s WHERE ZSUsuario = ? AND ZSContrasena = ? AND zsEstado = 'A'",
        zsTableName
    );

    try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {

        zsStmt.setString(1, usuario);
        zsStmt.setString(2, contrasena);

        try (ResultSet zsRs = zsStmt.executeQuery()) {
            return zsRs.next() ? zsMapResultSetToEntity(zsRs) : null;
        }

    } catch (SQLException e) {
        throw new ZSAppException(e.getMessage(), e, getClass(), "zsCheck");
    }
}

}



