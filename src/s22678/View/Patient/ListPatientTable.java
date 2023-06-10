package s22678.View.Patient;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListPatientTable extends JTable {
    private static DefaultTableModel tableModel;
    public ListPatientTable() {
        String[] columnNames = {"First Name", "Last Name", "Admission Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        tableModel.setRowCount(0);
        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.PATIENT)
                tableModel.addRow(person.getTableData());
        }
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
