package ZSAppComponent.ZSDesktopApp.ZSCustomControl;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.Component;
import ZSInfrastructureComponent.ZSAppStyle;

public class ZSComboBox<E> extends JComboBox<E> {

    public ZSComboBox() {
        super();
        customizeComponent();
    }

    private void customizeComponent() {
        setUI(new BasicComboBoxUI()); 
        setBorderDownLine();          
        setFont(ZSAppStyle.FONT);
        setForeground(ZSAppStyle.COLOR_FONT_LIGHT);
        setOpaque(true);
        setRenderer(new CustomRenderer());
    }

    private void setBorderDownLine() {
        int thickness = 1; // grosor de la línea
        Border bottomLine = BorderFactory.createMatteBorder(0, 0, thickness, 0, ZSAppStyle.COLOR_BORDER);
        setBorder(bottomLine);
    }

    private class CustomRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            
            JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            lbl.setFont(ZSAppStyle.FONT);
            lbl.setForeground(ZSAppStyle.COLOR_FONT_LIGHT);
            return lbl;
        }
    }
}