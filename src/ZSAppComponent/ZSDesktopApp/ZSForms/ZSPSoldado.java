package ZSAppComponent.ZSDesktopApp.ZSForms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import ZSBusinessLogicComponent.ZSEntities.ZSSoldadoBL;
import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;

public class ZSPSoldado extends JPanel {

    private JTable zsTable;
    private DefaultTableModel zsTableModel;
    private ZSSoldadoBL zsSoldadoBL;

    public ZSPSoldado() throws Exception {
        zsSoldadoBL = new ZSSoldadoBL();
        zsInitPanel();
        zsLoadData();
    }

    // ===== Inicializa UI =====
    private void zsInitPanel() {
        setLayout(new BorderLayout());

        // Columnas EXACTAS según la tabla Soldado
        String[] columns = {
                "ID",
                "Usuario",
                "Nombre",
                "Rango",
                "Estado"
        };

        zsTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 Solo lectura
            }
        };

        zsTable = new JTable(zsTableModel);
        zsTable.setRowHeight(24);
        zsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(zsTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    // ===== Carga datos desde DAO =====    
    private void zsLoadData() throws Exception {
        zsTableModel.setRowCount(0); // Limpia tabla

        List<ZSSoldadoDTO> soldados = zsSoldadoBL.zsGetAll();

        for (ZSSoldadoDTO s : soldados) {
            zsTableModel.addRow(new Object[]{
                    s.getIdZSSoldado(),
                    s.getIdZSSexo(),
                    s.getZSUsuario(),
                    s.getZSEstado()
            });
        }
    }
}
