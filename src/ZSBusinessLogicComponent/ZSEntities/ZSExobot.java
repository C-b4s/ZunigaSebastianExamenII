package ZSBusinessLogicComponent.ZSEntities;

import ZSBusinessLogicComponent.ZSFactoryBL;
import ZSDataAccessComponent.ZSDAOs.ZSExobotDAO;
import ZSDataAccessComponent.ZSDTOs.ZSExobotDTO;

public class ZSExobot extends ZSIAEXO {
    public ZSExobotDTO zsExobot = new ZSExobotDTO();

    public ZSFactoryBL<ZSExobotDTO> zsFactory = new ZSFactoryBL<>(ZSExobotDAO.class);

    public ZSBrazoDer zsBrazoDer;
    public ZSPiernaDer zsPiernaDer;
    public ZSBrazoIzq zsBrazoIzq;
    public ZSPiernaIzq zsPiernaIzq;
    
    public ZSExobot() {
    }

    public ZSExobot(ZSBrazoDer zsBrazoDer, ZSPiernaDer zsPiernaDer, ZSBrazoIzq zsBrazoIzq, ZSPiernaIzq zsPiernaIzq) {
        zsBrazoDer     = new ZSBrazoDer ();
        zsPiernaDer    = new ZSPiernaDer();
        zsBrazoIzq     = new ZSBrazoIzq ();
        zsPiernaIzq    = new ZSPiernaIzq();
    }

    

    

    
}
