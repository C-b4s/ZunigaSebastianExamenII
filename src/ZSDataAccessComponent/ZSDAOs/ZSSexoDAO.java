package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSSexoDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSSexoDAO extends ZSDataHelperSQLiteDAO<ZSSexoDTO>{

    public ZSSexoDAO(Class<ZSSexoDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSSexoDTO.class, "ZSSexo", "IdZSSexo");
    }

}
