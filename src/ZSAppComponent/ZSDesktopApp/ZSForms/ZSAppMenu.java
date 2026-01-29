package ZSAppComponent.ZSDesktopApp.ZSForms;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSButton;
import ZSInfrastructureComponent.ZSAppConfig;

public class ZSAppMenu extends JPanel{
private final List<ZSButton> menuItems = new ArrayList<>();
private final JPanel buttonsPanel = new JPanel () ;

    public ZSAppMenu() {
        zsInitComponents ();
    }
    
    private void zsInitComponents () {
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS) );
        setPreferredSize(new Dimension(250, getHeight()));
        
        // add-Logo
        try {
            Image Logo = ImageIO.read(ZSAppConfig.zsGetImgLogo());
            Logo = Logo.getScaledInstance(100,100,         Image.  SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(Logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonsPanel.setLayout (new BoxLayout (buttonsPanel, BoxLayout.         Y_AXIS) );
        add(buttonsPanel);

        // glue para empujar el copyright
        add(Box.createVerticalGlue());
        add(new JLabel ("--(🤖)-- 2K26 C-BIT ") ) ;
    }

    public void addMenuItem(ZSButton button) {
        menuItems.add(button);
        buttonsPanel.add(button);
        buttonsPanel.revalidate();
        buttonsPanel.repaint ();
    }

    public List<ZSButton> getmlenuItems () {
        return menuItems;

    }
}
