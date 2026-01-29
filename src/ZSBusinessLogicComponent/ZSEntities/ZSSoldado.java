package ZSBusinessLogicComponent.ZSEntities;

import ZSBusinessLogicComponent.ZSFactoryBL;
import ZSDataAccessComponent.ZSDAOs.ZSSoldadoDAO;
import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSInfrastructureComponent.ZSTools.ZSCMDColor;

public class ZSSoldado {
    // Refactorización: Se eliminaron los atributos de la clase ZSSoldado, pues la clase ZSSoldadoDTO ya los contenía
    ZSSoldadoDTO zsSoldadoDTO = new ZSSoldadoDTO();

    ZSFactoryBL<ZSSoldadoDTO> zsFactory = new ZSFactoryBL<>(ZSSoldadoDAO.class);

    //Refactorización: Se agregó el método checkLogin a ZSSoldado
    public Boolean zsCheckLogin(String zsUsuario, String zsContrasena){
        boolean auth1 = zsUsuario.equals("patmic") 
                         && zsContrasena.equals("123");

        boolean auth2 = zsUsuario.equals("ZunigaSebastian") 
                     && zsContrasena.equals("1706");
        if (auth1 || auth2) {
            System.out.println(ZSCMDColor.GREEN +"Acceso concedido.\n" + ZSCMDColor.RESET);
            return true;
        }
        System.out.println(ZSCMDColor.RED + "ERROR DE AUTENTICACIÓN");
        System.out.println("Usuario o contraseña incorrectos.");
        System.out.println("Por favor, intente nuevamente.\n" + ZSCMDColor.RESET);
        return false;
    }
}
