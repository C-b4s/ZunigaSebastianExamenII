package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSExobotDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSExobotDAO extends ZSDataHelperSQLiteDAO<ZSExobotDTO>{

    public ZSExobotDAO() throws ZSAppException {
        super(ZSExobotDTO.class, "ZSExobot", "IdZSExobot");
    }

    public ZSExobotDAO(Class<ZSExobotDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSExobotDTO.class, "ZSExobot", "IdZSExobot");
    }

}
