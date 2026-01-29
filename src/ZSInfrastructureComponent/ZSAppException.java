package ZSInfrastructureComponent;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ZSInfrastructureComponent.ZSTools.ZSCMDColor;

public class ZSAppException extends Exception{
    private static final DateTimeFormatter ZSFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public ZSAppException(String zsShowMsg) {
        super((zsShowMsg == null || zsShowMsg.isBlank())? ZSAppConfig.MSG_DEFAULT_ERROR : zsShowMsg);
        saveLogFile(null, null, null);
    }
    public ZSAppException(String zsShowMsg, Exception e, Class<?> zsClase, String zsMetodo) {
        super((zsShowMsg == null || zsShowMsg.isBlank())? ZSAppConfig.MSG_DEFAULT_ERROR : zsShowMsg);
        saveLogFile(e.getMessage(), zsClase, zsMetodo);
    }

    private void saveLogFile(String zsLogMsg, Class<?> zsClase, String zsMetodo) {
        String zsTimeStamp  = LocalDateTime.now().format(ZSFORMATTER);
        String zsClassName  = (zsClase == null) ? ZSAppConfig.MSG_DEFAULT_CLASS : zsClase.getSimpleName();
        String zsMethodName = (zsMetodo == null || zsMetodo.isBlank()) ? ZSAppConfig.MSG_DEFAULT_METHOD : zsMetodo;
        zsLogMsg = (zsLogMsg == null || zsLogMsg.isBlank())? ZSAppConfig.MSG_DEFAULT_ERROR : zsLogMsg;
        zsLogMsg = String.format("┌─🤖❌─ SHOW ❱❱ %s \n└── LOG » %s | %s.%s | %s", getMessage(), zsTimeStamp, zsClassName, zsMethodName,zsLogMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(ZSAppConfig.zsGETLOGFILE(), true))) {
            System.err.println(ZSCMDColor.BLUE  + zsLogMsg);
            writer.println(zsLogMsg);
        } catch (Exception e) {
            System.err.println(ZSCMDColor.RED  + "[AppException.saveLogFile] ❱ " + e.getMessage());
        }finally {
            System.out.println(ZSCMDColor.RESET);
        }
    }


}
