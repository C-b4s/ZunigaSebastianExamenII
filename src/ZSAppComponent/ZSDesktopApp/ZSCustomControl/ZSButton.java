package ZSAppComponent.ZSDesktopApp.ZSCustomControl;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import ZSInfrastructureComponent.ZSAppStyle;

import javax.swing.ImageIcon;


public class ZSButton extends JButton implements MouseListener {
    public ZSButton(String zsText){
        zsCustomizeComponent(zsText);
    }
    public ZSButton(String zsText, String zsIconPath){
        zsCustomizeComponent(zsText, zsIconPath);
    }

    public void zsCustomizeComponent(String zsText, String zsIconPath){ 
        setSize(20, 70);
        addMouseListener(this);
        zsCustomizeComponent(zsText);
        setBounds(50, 30, 90, 20); 
        setIcon(new ImageIcon(zsIconPath));
        setFont(ZSAppStyle.FONT);
    }
    public void zsCustomizeComponent(String zsText) {
        setText(zsText);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(ZSAppStyle.COLOR_FONT);
        setHorizontalAlignment(ZSAppStyle.ALIGNMENT_LEFT);
        setFont(ZSAppStyle.FONT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Este evento no se utiliza en este componente.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(ZSAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(ZSAppStyle.CURSOR_DEFAULT);
    }
}
