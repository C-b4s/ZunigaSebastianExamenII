package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSExobotTipoDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSExobotTipoDAO extends ZSDataHelperSQLiteDAO<ZSExobotTipoDTO>{

    public ZSExobotTipoDAO(Class<ZSExobotTipoDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSExobotTipoDTO.class, "ZSExobotTipo", "IdZSExobotTipo");
    }

}
