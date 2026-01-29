package ZSAppComponent.ZSDesktopApp.ZSCustomControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import ZSInfrastructureComponent.ZSAppStyle;

public class ZSLabel extends JLabel{
    public ZSLabel(){
        zsCustomizeComponent();
    }
    public ZSLabel(String zsText){
        setText(zsText);
        zsCustomizeComponent();
    }
    private void zsCustomizeComponent(){
        zsSetCustomizeComponent(getText(), ZSAppStyle.FONT, ZSAppStyle.COLOR_FONT_LIGHT, ZSAppStyle.ALIGNMENT_LEFT);
    }
    public void zsSetCustomizeComponent(String zsText, Font  zsFont, Color zsColor, int zsAlignment) {
        setText(zsText);
        setFont(zsFont);
        setOpaque(false);
        setBackground(null);
        setForeground(zsColor);
        setHorizontalAlignment(zsAlignment);
        //setIcon(new ImageIcon(iconPath));
}
}
