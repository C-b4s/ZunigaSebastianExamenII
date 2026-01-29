package ZSBusinessLogicComponent.ZSEntities;

import ZSBusinessLogicComponent.pkZSInterfaces.IZSIIAEXO;
import ZSBusinessLogicComponent.pkZSMunicion.ZSMunicion;

public abstract class ZSIAEXO implements IZSIIAEXO{

    public ZSIAEXO() {
    }

    @Override
    public Boolean disparar(ZSMunicion zsMun) {
        return true;
    }

}
