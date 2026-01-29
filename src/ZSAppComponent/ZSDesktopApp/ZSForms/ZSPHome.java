package ZSAppComponent.ZSDesktopApp.ZSForms;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Image;
import ZSInfrastructureComponent.ZSAppConfig;
import ZSInfrastructureComponent.ZSAppException;
import ZSInfrastructureComponent.ZSAppMSG;

public class ZSPHome extends JPanel{
    private ImageIcon originalIcon;

    public ZSPHome() {
        originalIcon = new ImageIcon(ZSAppConfig.zsGetImgMain());
        setLayout(new BorderLayout());

        // Escalado dinámico cuando el componente se redimensiona
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateImage();
            }
        });
    }

    private void updateImage() {
        try {
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                Image originalImage = originalIcon.getImage();
                Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                removeAll(); // Limpiar contenido anterior
                JLabel imageLabel = new JLabel(scaledIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                imageLabel.setVerticalAlignment(SwingConstants.CENTER);
                add(imageLabel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        } catch (Exception e) {
            ZSAppException er = new ZSAppException("Ups..! Error en la imagen de inicio", e, getClass(), "initComponents()");
            ZSAppMSG.showMsgError(er.getMessage());
        }
    }
}
