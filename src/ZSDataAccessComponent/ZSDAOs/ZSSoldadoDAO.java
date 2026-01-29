package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSSoldadoDAO extends ZSDataHelperSQLiteDAO<ZSSoldadoDTO>{

    public ZSSoldadoDAO(Class<ZSSoldadoDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSSoldadoDTO.class, "ZSSoldado", "IdZSSoldado");
    }

}
