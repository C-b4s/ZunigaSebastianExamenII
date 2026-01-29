package ZSAppComponent.ZSDesktopApp.ZSForms;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSButton;
import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSComboBox;
import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSLabel;


public class ZSAppStart extends JFrame{
    
    
    public ZSAppStart(String zsTitleApp) throws HeadlessException {
        zsInitComponents(zsTitleApp);

    getContentPane().setLayout(
            new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
    );

    // ===== Labels =====
    add(new ZSLabel("Alumno(s):"));
    add(new ZSLabel("Nombre: Sebastián Zúñiga"));
    add(new ZSLabel("Cédula: 1727915942"));

    // ===== Panel horizontal =====
    JPanel zsSearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
;

    // ===== ZSComboBox =====
    ZSComboBox<String> zsComboTablas = new ZSComboBox<>();
    zsComboTablas.addItem("Soldados");
    zsComboTablas.addItem("Armas");
    zsComboTablas.addItem("Misiones");
    zsComboTablas.addItem("Rangos");

    // ===== ZSButtons =====
    ZSButton zsBtnAgregar = new ZSButton("Agregar");
    ZSButton zsBtnBuscar  = new ZSButton("Buscar");

    // ===== Agregar al panel =====
    zsSearchPanel.add(zsComboTablas);
    zsSearchPanel.add(zsBtnAgregar);
    zsSearchPanel.add(zsBtnBuscar);

    // ===== Agregar panel al frame =====
    add(zsSearchPanel);

    revalidate();
    repaint();
        
    }
    

    private void zsInitComponents(String tilteApp) {
        setTitle (tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo (null); // Centrar en La pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear un contenedor para Los dos paneles usando BorderLayout
        Container container = getContentPane();
        container. setLayout (new BorderLayout () );

        // Agregar Los paneles al contenedor
        
        setVisible(true);
    }
    
}
