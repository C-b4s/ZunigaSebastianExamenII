package ZSAppComponent.ZSDesktopApp.ZSForms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSButton;
import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSComboBox;
import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSLabel;

public class ZSAppStart extends JFrame {

    private CardLayout zsCardLayout;
    private JPanel zsMainPanel;
    private Map<String, JPanel> zsPanels;

    public ZSAppStart(String zsTitleApp) throws Exception {

        zsInitComponents(zsTitleApp);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // ===== PANEL MENU (IZQUIERDA) =====
        ZSAppMenu zsPnlMenu = new ZSAppMenu();
        container.add(zsPnlMenu, BorderLayout.WEST);

        // ===== PANEL SUPERIOR =====
        JPanel zsTopPanel = new JPanel();
        zsTopPanel.setLayout(new BoxLayout(zsTopPanel, BoxLayout.Y_AXIS));

        zsTopPanel.add(new ZSLabel("Alumno(s):"));
        zsTopPanel.add(new ZSLabel("Nombre: Sebastián Zúñiga"));
        zsTopPanel.add(new ZSLabel("Cédula: 1727915942"));

        // ===== PANEL BUSQUEDA =====
        JPanel zsSearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        ZSComboBox<String> zsComboTablas = new ZSComboBox<>();
        zsComboTablas.addItem("Inicio");
        zsComboTablas.addItem("Soldados");
        zsComboTablas.addItem("Exobots");

        ZSButton zsBtnAgregar = new ZSButton("Agregar");
        ZSButton zsBtnBuscar  = new ZSButton("Buscar");

        zsSearchPanel.add(zsComboTablas);
        zsSearchPanel.add(zsBtnAgregar);
        zsSearchPanel.add(zsBtnBuscar);

        zsTopPanel.add(zsSearchPanel);
        container.add(zsTopPanel, BorderLayout.NORTH);

        // ===== CARD LAYOUT =====
        zsCardLayout = new CardLayout();
        zsMainPanel = new JPanel(zsCardLayout);
        zsPanels = new HashMap<>();

        // ===== PANELES =====
        ZSPHome panelHome = new ZSPHome();
        ZSPSoldado panelSoldado = new ZSPSoldado();
        ZSPExobot panelExobot = new ZSPExobot();

        zsPanels.put("Inicio", panelHome);
        zsPanels.put("Exobots", panelExobot);
        zsPanels.put("Soldados", panelSoldado);

        zsMainPanel.add(panelHome, "Inicio");
        zsMainPanel.add(panelExobot, "Exobots");
        zsMainPanel.add(panelSoldado, "Soldados");

        container.add(zsMainPanel, BorderLayout.CENTER);

        // ===== EVENTO COMBOBOX =====
        zsComboTablas.addActionListener(e -> {
            String selected = (String) zsComboTablas.getSelectedItem();
            if (zsPanels.containsKey(selected)) {
                zsCardLayout.show(zsMainPanel, selected);
            }
        });

        setVisible(true);
    }

    private void zsInitComponents(String titleApp) {
        setTitle(titleApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
