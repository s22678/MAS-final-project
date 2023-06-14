package s22678.View.Doctor.List;

import s22678.Model.Person;
import s22678.View.Doctor.Show.ShowDoctorFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static s22678.View.Main.MainView.getSansSerifFont;

public class ListDoctorTable extends JTable {
    private static DefaultTableModel tableModel;

    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ListDoctorTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(getSansSerifFont());
        getTableHeader().setFont(getSansSerifFont());
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"PESEL", "First Name", "Last Name", "Specialization"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = getSelectedRow();
                    String pesel = (String) getValueAt(row, 0);
                    String firstName = (String) getValueAt(row, 1);
                    String lastName = (String) getValueAt(row, 2);

                    Person doctor = Person.getPersonByFullNameandPesel(pesel, firstName, lastName);
                    new ShowDoctorFrame(doctor);
                }
            }
        });
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
