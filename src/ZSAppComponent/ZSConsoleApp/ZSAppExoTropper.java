package ZSAppComponent.ZSConsoleApp;

import ZSAppComponent.ZSDesktopApp.ZSForms.ZSAppSplashScreen;
import ZSAppComponent.ZSDesktopApp.ZSForms.ZSAppStart;
import ZSBusinessLogicComponent.ZSEntities.ZSSoldado;
import ZSInfrastructureComponent.ZSAppException;
import ZSInfrastructureComponent.ZSTools.ZSCMD;
import ZSInfrastructureComponent.ZSTools.ZSCMDColor;
import ZSInfrastructureComponent.ZSTools.ZSCMDProgress;


public class ZSAppExoTropper {

    public void zsStart(ZSSoldado zsSoldado) throws InterruptedException{
        ZSCMD.println("AppExoTropper iniciada...");
        ZSCMDProgress.showSpinner();
        System.out.println(ZSCMDColor.RESET);
        try{
            if(zsAutenticar(zsSoldado)){
                new ZSAppSplashScreen();
                ZSAppStart zsAppStart = new ZSAppStart("AppExoTropper");
            }else{
                ZSCMD.printlnError("Acceso denegado. Saliendo del sistema...");
                System.exit(0);
            }
        }catch(Exception e){
            ZSCMD.printlnError("Error durante la autenticación: ");;
        }
        
    }

    public Boolean zsAutenticar(ZSSoldado zsSoldado) throws ZSAppException{
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
