package ZSDataAccessComponent.ZSInterfaces;

import java.util.List;

import ZSInfrastructureComponent.ZSAppException;

public interface IZSDataHelperSQLiteDAO<T> {
    List<T> zsReadAll()                      throws ZSAppException;//listado de filas         
    T       zsReadBy (Integer id)            throws ZSAppException;//una sola fila            
    boolean zsCreate (T entity)              throws ZSAppException;
    boolean zsUpdate (T entity)              throws ZSAppException;
    boolean zsDelete (Integer id)            throws ZSAppException;
    Integer zsGetMaxReg(String zsCellName)   throws ZSAppException;
    Integer zsGetMinReg(String zsCellName)   throws ZSAppException;
    Integer zsGetCountReg()                  throws ZSAppException;
}

