package ZSAppComponent.ZSDesktopApp.ZSForms;

import javax.swing.*;
import javax.swing.border.LineBorder;

import ZSBusinessLogicComponent.ZSFactoryBL;

import java.awt.*;
import java.util.List;

import ZSDataAccessComponent.ZSDAOs.ZSExobotDAO;
import ZSDataAccessComponent.ZSDTOs.ZSExobotDTO;
import ZSAppComponent.ZSDesktopApp.ZSCustomControl.ZSButton;
import ZSInfrastructureComponent.ZSAppStyle;

public class ZSPExobot extends JPanel {

    private ZSFactoryBL <ZSExobotDTO> zsExobotBL = new ZSFactoryBL<>(ZSExobotDAO.class);
    private JPanel zsTablePanel;
    private List<ZSExobotDTO> exobotsList;
    private int selectedRow = -1;
    private java.util.Map<JPanel, Integer> panelRowMap = new java.util.HashMap<>();

    public ZSPExobot() throws Exception {

        zsInitPanel();
        zsLoadData();
    }

    // ===== Inicialización =====
    private void zsInitPanel() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        zsTablePanel = new JPanel(new GridBagLayout());
        zsTablePanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(zsTablePanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.CENTER);

        // ===== Panel Inferior con Botón =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBackground(Color.WHITE);

        ZSButton btnEntrenarArma = new ZSButton("Entrenar Arma");
        btnEntrenarArma.addActionListener(e -> zsEntrenarArmaAccion());

        bottomPanel.add(btnEntrenarArma);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // ===== Carga de datos =====
    private void zsLoadData() throws Exception {

        zsTablePanel.removeAll();
        panelRowMap.clear();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0;
        gbc.weighty = 0;

        // ===== ENCABEZADOS =====
        gbc.gridy = 0;

        gbc.gridx = 0;
        zsTablePanel.add(zsHeaderCell("IdExobot"), gbc);

        gbc.gridx = 1;
        zsTablePanel.add(zsHeaderCell("TipoExobot"), gbc);

        gbc.gridx = 2;
        zsTablePanel.add(zsHeaderCell("Entreno"), gbc);

        gbc.gridx = 3;
        zsTablePanel.add(zsHeaderCell("No Accion"), gbc);

        // ===== FILAS =====
        List<ZSExobotDTO> exobots = zsExobotBL.zsGetAll();
        exobotsList = exobots;
        int row = 1;

        for (ZSExobotDTO e : exobots) {

            gbc.gridy = row;

            gbc.gridx = 0;
            JPanel cellPanel = zsDataCellSelectable(String.valueOf(e.getIdZSExobot()), row - 1);
            panelRowMap.put(cellPanel, row - 1);
            zsTablePanel.add(cellPanel, gbc);

            gbc.gridx = 1;
            cellPanel = zsDataCellSelectable(String.valueOf(e.getIdZSExobotTipo()), row - 1);
            panelRowMap.put(cellPanel, row - 1);
            zsTablePanel.add(cellPanel, gbc);

            gbc.gridx = 2;
            cellPanel = zsDataCellSelectable(e.getZSEntreno(), row - 1);
            panelRowMap.put(cellPanel, row - 1);
            zsTablePanel.add(cellPanel, gbc);

            gbc.gridx = 3;
            cellPanel = zsDataCellSelectable(String.valueOf(e.getZSNoAccion()), row - 1);
            panelRowMap.put(cellPanel, row - 1);
            zsTablePanel.add(cellPanel, gbc);

            row++;
        }

        revalidate();
        repaint();
    }

    // ===== Celda de Datos Seleccionable =====
    private JPanel zsDataCellSelectable(String text, int rowIndex) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(120, 44));

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font(
                ZSAppStyle.FONT_FAMILY,
                Font.PLAIN,
                16
        ));

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRow = rowIndex;
                zsHighlightRow(rowIndex);
            }
        });

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private void zsHighlightRow(int rowIndex) {
        // Resetear todos los paneles de datos (no encabezados)
        for (JPanel panel : panelRowMap.keySet()) {
            panel.setBackground(Color.WHITE);
        }
        // Resaltar la fila seleccionada
        for (JPanel panel : panelRowMap.keySet()) {
            if (panelRowMap.get(panel) == rowIndex) {
                panel.setBackground(new Color(200, 220, 255));
            }
        }
        revalidate();
        repaint();
    }

    private void zsEntrenarArmaAccion() {
        if (selectedRow >= 0 && selectedRow < exobotsList.size()) {
            try {
                ZSExobotDTO exobot = exobotsList.get(selectedRow);
                exobot.setZSEntreno("SI");
                // Asignar valores por defecto si están null
                if (exobot.getZSEstado() == null) exobot.setZSEstado("A");
                if (exobot.getZSFechaCreacion() == null) exobot.setZSFechaCreacion(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
                // No asignar ZSFechaModificacion, dejar que la BD lo actualice automáticamente
                
                zsExobotBL.zsUpd(exobot);
                selectedRow = -1;
                zsLoadData();
                JOptionPane.showMessageDialog(this, "Exobot entrenado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al entrenar el exobot: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // ===== Celda de Datos =====
    private JPanel zsHeaderCell(String text) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0, 140, 0));
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(120, 48));

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font(
                ZSAppStyle.FONT_FAMILY,
                Font.BOLD,
                17
        ));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // ===== Celda de Datos =====
    private JPanel zsDataCell(String text) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(120, 44));

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font(
                ZSAppStyle.FONT_FAMILY,
                Font.PLAIN,
                16
        ));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
