package ZSAppComponent.ZSConsoleApp;

import ZSBusinessLogicComponent.ZSEntities.ZSSoldado;
import ZSInfrastructureComponent.ZSTools.ZSCMDColor;
import ZSInfrastructureComponent.ZSTools.ZSCMDProgress;


public class ZSAppExoTropper {

    public void zsStart(ZSSoldado zsSoldado) throws InterruptedException{
        System.out.println(ZSCMDColor.BLUE + "Sistema Ruso iniciado...");
        ZSCMDProgress.showSpinner();
        System.out.println(ZSCMDColor.RESET);
        try{
            if(zsAutenticar(zsSoldado)){
                
            }else{
                System.out.println(ZSCMDColor.RED + "Acceso denegado. Saliendo del sistema..." + ZSCMDColor.RESET);
                System.exit(0);
            }
        }catch(Exception e){
            System.out.println(ZSCMDColor.RED + "Error durante la autenticación: " + e.getMessage() + ZSCMDColor.RESET);
        }
        
    }

    public Boolean zsAutenticar(ZSSoldado zsSoldado){
        int zsCountTry = 0;
        while (zsCountTry++ < 3){
            System.out.println("=================== LOGIN ===================");
            System.out.print("Ingrese su usuario: ");
            String zsU = System.console().readLine();
            System.out.print("Ingrese su contrasena: ");
            String zsP = System.console().readLine();

            if (zsSoldado.zsCheckLogin(zsU,zsP)){
                return true;
            }
        }
        return false;


    }
}
