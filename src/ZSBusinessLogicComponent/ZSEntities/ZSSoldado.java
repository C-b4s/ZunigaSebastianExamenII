package ZSBusinessLogicComponent.ZSEntities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSInfrastructureComponent.ZSAppConfig;
import ZSInfrastructureComponent.ZSAppException;
import ZSInfrastructureComponent.ZSTools.ZSCMDColor;

public class ZSSoldado {

    ZSSoldadoDTO zsSoldadoDTO = new ZSSoldadoDTO();
    ZSSoldadoBL zsSoldadoBl;
    String zsUsuario;
    String zsContrasena;


    private static final DateTimeFormatter ZS_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ZSSoldado(String zsUsuario, String zsContrasena) throws ZSAppException {
        zsSoldadoBl = new ZSSoldadoBL();
        this.zsUsuario = zsUsuario;
        this.zsContrasena = zsContrasena;
    }

    // Refactorización: Se agregó el método checkLogin a ZSSoldado
    public Boolean zsCheckLogin(String zsUsuario, String zsContrasena) throws ZSAppException {

        ZSSoldadoDTO zsLoginAttempt =
                zsSoldadoBl.zsSoldadoDAO.zsCheck(zsUsuario, zsContrasena);

        boolean auth = (zsLoginAttempt != null);

        if (auth) {
            System.out.println(ZSCMDColor.GREEN +
                    "GOOD. Acceso concedido.\n" + ZSCMDColor.RESET);

            zsWriteExoTracer("GOOD", "Acceso concedido");
            return true;
        }

        System.out.println(ZSCMDColor.RED +
                "ERROR. Acceso denegado.\n" + ZSCMDColor.RESET);

        zsWriteExoTracer("ERROR", "Acceso denegado");
        return false;
    }

    private void zsWriteExoTracer(String level, String message) {
    String time = LocalDateTime.now().format(ZS_FORMAT);

    try {
        Path path = Paths.get(ZSAppConfig.zsGETEXOTRACER()).toAbsolutePath();

        String line = time + " | " + level + " : " + message + System.lineSeparator();

        Files.write(
                path,
                line.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );

    } catch (IOException e) {
        System.err.println("ERROR ExoTracer ❱❱ " + e.getMessage());
    }
}


}
