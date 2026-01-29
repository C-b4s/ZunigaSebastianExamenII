import ZSAppComponent.ZSConsoleApp.ZSAppExoTropper;
import ZSBusinessLogicComponent.ZSEntities.ZSSoldado;

public class App {
    public static void main(String[] args) throws Exception {
        ZSAppExoTropper zsAppExoTropper = new ZSAppExoTropper();
        ZSSoldado zsSoldado = new ZSSoldado("patmic","123");

        zsAppExoTropper.zsStart(zsSoldado);
    }
}
