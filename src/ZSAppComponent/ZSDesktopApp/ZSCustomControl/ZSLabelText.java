package ZSAppComponent.ZSDesktopApp.ZSCustomControl;
import javax.swing.*;

import ZSInfrastructureComponent.ZSAppStyle;

import java.awt.*;

public class ZSLabelText extends JPanel{
    private ZSLabel    zsLblEtiqueta = new ZSLabel();
    private ZSTextBox  zsTxtContenido= new ZSTextBox();

    public ZSLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        zsLblEtiqueta.zsSetCustomizeComponent(  etiqueta, 
                                            ZSAppStyle.FONT_SMALL, 
                                            ZSAppStyle.COLOR_FONT_LIGHT, 
                                            ZSAppStyle.ALIGNMENT_LEFT); 
        add(zsLblEtiqueta, BorderLayout.NORTH);
        add(zsTxtContenido, BorderLayout.CENTER);
    }
}
