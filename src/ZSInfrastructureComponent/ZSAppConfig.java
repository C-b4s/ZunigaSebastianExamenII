package ZSInfrastructureComponent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import ZSInfrastructureComponent.ZSTools.ZSCMD;


public abstract class ZSAppConfig {
    private static final Properties props = new Properties();
    
    private static final String ZSAPP_PROPERTIES      = "src/app.properties";
    private static final String ZSKEY_DB_NAME         = "db.File";
    private static final String ZSKEY_FILE_LOG        = "df.logFile";
    private static final String ZSKEY_FILE_DATA       = "df.AntCoor";
    private static final String ZSKEY_FILE_ANTNEST    = "df.AntNest";
    private static final String ZSKEY_FILE_ANTFOOD    = "df.AntFood";
    private static final String ZSKEY_RES_IMG_MAIN    = "res.img.Main";
    private static final String ZSKEY_RES_IMG_LOGO    = "res.img.Logo";
    private static final String ZSKEY_RES_IMG_SPLASH  = "res.img.Splash";

    // Configuración dinámica (Sin recompilar)
    public static final String zsGETDATABASE  (){ return zsGetProperty( ZSKEY_DB_NAME      ); }
    public static final String zsGETLOGFILE   (){ return zsGetProperty( ZSKEY_FILE_LOG     ); }
    public static final String zsGETDATAFILE  (){ return zsGetProperty( ZSKEY_FILE_DATA    ); }
    public static final String zsGETANTFOOD   (){ return zsGetProperty( ZSKEY_FILE_ANTFOOD ); }
    public static final String zsGETANTNEST   (){ return zsGetProperty( ZSKEY_FILE_ANTNEST ); }
    // Resources . Recurso estático empaquetado
    public static final URL zsGetImgMain      (){ return zsGetAppResource(ZSKEY_RES_IMG_MAIN  ); }
    public static final URL zsGetImgLogo      (){ return zsGetAppResource(ZSKEY_RES_IMG_LOGO  ); }
    
    public static final URL zsGetImgSplash    (){ return zsGetAppResource(ZSKEY_RES_IMG_SPLASH); }

    // AppMSGs
    public static final String MSG_DEFAULT_ERROR    = "Ups! Error inesperado. Por favor,contacte       al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS    = "undefined";
    public static final String MSG_DEFAULT_METHOD   = "undefined";
    static {
        try (InputStream appProperties = new FileInputStream(ZSAPP_PROPERTIES)) {
            props.load(appProperties);
        } catch (IOException e) {
            ZSCMD.printlnError("ERROR al cargar ❱❱ " + e.getMessage());
        }
    }

    private ZSAppConfig(){}

    static String zsGetProperty(String key) {
        String path = props.getProperty(key);
        ZSCMD.println("AppConfig ❱❱ " + ZSAPP_PROPERTIES + "." + key + " : " + path);
        if(path != null)
            return path;
        else
            ZSCMD.printlnError("ERROR ❱❱ " + ZSAPP_PROPERTIES + "." + key + " : " + path);
        return null;
    }

    static URL zsGetAppResource(String zsKeyResImgLogo) {
        String path = zsGetProperty(zsKeyResImgLogo);
        if(path != null)
            return  ZSAppConfig.class.getResource(path);
        else
            ZSCMD.printlnError("ERROR ❱❱ getAppResource : " + ZSAPP_PROPERTIES +"." + zsKeyResImgLogo + " : "+ path);
        return null;
    }

}
