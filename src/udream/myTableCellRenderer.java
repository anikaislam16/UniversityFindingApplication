package udream;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class myTableCellRenderer implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (Component) value;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //MultiLineCellRenderer
}
