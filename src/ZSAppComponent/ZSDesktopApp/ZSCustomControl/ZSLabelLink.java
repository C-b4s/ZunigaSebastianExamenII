package ZSAppComponent.ZSDesktopApp.ZSCustomControl;
import javax.swing.ImageIcon;

import ZSInfrastructureComponent.ZSAppStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ZSLabelLink extends ZSLabel implements MouseListener{
        ZSLabelLink(String zsText){
        super(zsText);
        zsSetPersonalizacion();
    }

    ZSLabelLink(String zsText, String zsIconPath){
        super(zsText);
        zsSetPersonalizacion();
        setIcon(new ImageIcon(zsIconPath));
    }
    
    void zsSetPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(ZSAppStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // code
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(ZSAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(ZSAppStyle.CURSOR_DEFAULT);
    }
}
