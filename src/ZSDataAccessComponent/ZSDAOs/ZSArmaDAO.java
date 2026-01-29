package ZSDataAccessComponent.ZSDAOs;

import ZSDataAccessComponent.ZSDTOs.ZSArmaDTO;
import ZSDataAccessComponent.ZSHelpers.ZSDataHelperSQLiteDAO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSArmaDAO extends ZSDataHelperSQLiteDAO<ZSArmaDTO> {

    public ZSArmaDAO(Class<ZSArmaDTO> ZSDtoClass, String zsTableName, String zsTablePK) throws ZSAppException {
        super(ZSArmaDTO.class, "ZSArma", "IdZSArma");
    }

}   
