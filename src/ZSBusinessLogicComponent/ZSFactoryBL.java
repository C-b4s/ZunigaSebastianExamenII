package ZSBusinessLogicComponent;

import java.util.List;

import ZSDataAccessComponent.ZSInterfaces.IZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSFactoryBL <T> {
    private final IZSDataHelperSQLiteDAO<T> zsODAO;

    public ZSFactoryBL(Class<? extends IZSDataHelperSQLiteDAO<T>> classDAO) {
        try {
            this.zsODAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            ZSAppException er = new ZSAppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(...)");
            throw new RuntimeException(er);
        }
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public FactoryBL(Supplier<IZSDataHelperSQLiteDAO<T>> supplier) {
    //     this.zsODAO = supplier.get(); 
    // }
 
    public List<T> zsGetAll() throws ZSAppException {
         return zsODAO.zsReadAll();
    }

    public T zsGetBy(Integer zsId) throws ZSAppException {
        return zsODAO.zsReadBy(zsId);
    }

    public boolean zsAdd(T zsOT) throws ZSAppException {
        return zsODAO.zsCreate(zsOT);
    }

    public boolean zsUpd(T zsOT) throws ZSAppException {
        return zsODAO.zsUpdate(zsOT);
    }

    public boolean zsDel(Integer zsId) throws ZSAppException {
        return zsODAO.zsDelete(zsId);
    }

    public Integer zsGetMaxReg(String cellName) throws ZSAppException{
        return zsODAO.zsGetMaxReg(cellName);
    }

    public Integer zsGetMinReg(String cellName) throws ZSAppException{
        return zsODAO.zsGetMinReg(cellName);
    }

    public Integer zsGetCountReg() throws Exception{
        return zsODAO.zsGetCountReg();
    }
}
