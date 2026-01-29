package ZSBusinessLogicComponent.ZSEntities.pkZSArma;

import ZSBusinessLogicComponent.ZSFactoryBL;
import ZSDataAccessComponent.ZSDAOs.ZSArmaDAO;
import ZSDataAccessComponent.ZSDTOs.ZSArmaDTO;


public abstract class ZSArma {
    ZSArmaDTO zsArma = new ZSArmaDTO();

    ZSFactoryBL<ZSArmaDTO> zsFactory = new ZSFactoryBL<>(ZSArmaDAO.class);
}
