package s22678.View.Patient.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListPatientTable extends JTable {
    private static DefaultTableModel tableModel;
    public ListPatientTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(sansSerifFont);
        getTableHeader().setFont(sansSerifFont);
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"PESEL", "First Name", "Last Name", "Admission Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.PATIENT)
                tableModel.addRow(person.getPatientTableData());
        }
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
