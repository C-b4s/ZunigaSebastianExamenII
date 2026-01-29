package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSArmaTipoDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSArmaTipoDAO extends ZSDataHelperSQLiteDAO<ZSArmaTipoDTO>{

    public ZSArmaTipoDAO(Class<ZSArmaTipoDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSArmaTipoDTO.class, "ZSArmaTipo", "IdZSArmaTipo");
    }


}
