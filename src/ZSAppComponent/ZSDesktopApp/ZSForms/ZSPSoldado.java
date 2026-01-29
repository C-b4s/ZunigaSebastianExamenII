package ZSAppComponent.ZSDesktopApp.ZSForms;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

import ZSBusinessLogicComponent.ZSEntities.ZSSoldadoBL;
import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSInfrastructureComponent.ZSAppStyle;

public class ZSPSoldado extends JPanel {

    private ZSSoldadoBL zsSoldadoBL;
    private JPanel zsTablePanel;

    public ZSPSoldado() throws Exception {
        zsSoldadoBL = new ZSSoldadoBL();
        zsInitPanel();
        zsLoadData();
    }

    // ===== Inicialización del panel =====
    private void zsInitPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        zsTablePanel = new JPanel(new GridBagLayout());
        zsTablePanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(zsTablePanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        add(scrollPane, BorderLayout.WEST);
    }

    // ===== Carga de datos =====
    private void zsLoadData() throws Exception {

        zsTablePanel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0;
        gbc.weighty = 0;

        // ===== ENCABEZADOS =====
        gbc.gridy = 0;

        gbc.gridx = 0;
        zsTablePanel.add(zsHeaderCell("ID"), gbc);

        gbc.gridx = 1;
        zsTablePanel.add(zsHeaderCell("USUARIO"), gbc);

        // ===== FILAS =====
        List<ZSSoldadoDTO> soldados = zsSoldadoBL.zsGetAll();
        int row = 1;

        for (ZSSoldadoDTO s : soldados) {

            gbc.gridy = row;

            gbc.gridx = 0;
            zsTablePanel.add(zsDataCell(String.valueOf(s.getIdZSSoldado())), gbc);

            gbc.gridx = 1;
            zsTablePanel.add(zsDataCell(s.getZSUsuario()), gbc);

            row++;
        }

        // ===== Empujador horizontal =====
        gbc.gridx = 2;
        gbc.weightx = 1;
        zsTablePanel.add(Box.createHorizontalGlue(), gbc);

        revalidate();
        repaint();
    }

    // ===== Celda encabezado =====
    private JPanel zsHeaderCell(String text) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(0, 140, 0)); // Verde institucional
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(220, 48));

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

    // ===== Celda de datos =====
    private JPanel zsDataCell(String text) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setPreferredSize(new Dimension(220, 44));

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
