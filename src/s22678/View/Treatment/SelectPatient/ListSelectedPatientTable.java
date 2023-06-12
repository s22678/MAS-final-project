package s22678.View.Treatment.SelectPatient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListSelectedPatientTable extends JTable {
    private static DefaultTableModel tableModel;
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ListSelectedPatientTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(sansSerifFont);
        getTableHeader().setFont(sansSerifFont);
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"PESEL", "First Name", "Last Name", "Admission Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
