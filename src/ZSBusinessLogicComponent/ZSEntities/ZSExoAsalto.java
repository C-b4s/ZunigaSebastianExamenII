package ZSBusinessLogicComponent.ZSEntities;

import ZSBusinessLogicComponent.ZSEntities.pkZSArma.ZSFusil;
import ZSBusinessLogicComponent.ZSEntities.pkZSArma.ZSRevolver;
import ZSBusinessLogicComponent.pkZSInterfaces.IZSEntrenableFusil;
import ZSBusinessLogicComponent.pkZSInterfaces.IZSEntrenableRevolver;

public class ZSExoAsalto extends ZSExobot implements IZSEntrenableFusil, IZSEntrenableRevolver{

    @Override
    public Boolean zsAprenderFusil(ZSFusil zsFl) {
        return true;
    }

    @Override
    public Boolean zsAprenderRevolver(ZSRevolver zsRv) {
        return true;
    }
    
}
