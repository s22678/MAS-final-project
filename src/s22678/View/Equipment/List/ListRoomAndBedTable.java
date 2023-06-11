package s22678.View.Equipment.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListRoomAndBedTable extends JTable {
    private static DefaultTableModel tableModel;
    public ListRoomAndBedTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(sansSerifFont);
        getTableHeader().setFont(sansSerifFont);
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"Room number", "Bed number", "Occupied", "Patient name"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.DOCTOR)
                tableModel.addRow(person.getDoctorTableData());
        }
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
