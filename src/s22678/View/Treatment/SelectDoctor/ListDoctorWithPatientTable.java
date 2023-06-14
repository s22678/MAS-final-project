package s22678.View.Treatment.SelectDoctor;

import s22678.Model.Person;
import s22678.View.Main.MainView;
import s22678.View.Treatment.SelectPatient.ListSelectedPatientActionListener;
import s22678.View.Treatment.SelectPatient.ListSelectedPatientPanel;
import s22678.View.Treatment.SelectPatient.ListSelectedPatientTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static s22678.Controller.DoctorController.getDoctorByPesel;
import static s22678.View.Main.MainView.getSansSerifFont;

public class ListDoctorWithPatientTable extends JTable {
    private static DefaultTableModel tableModel;

    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ListDoctorWithPatientTable() {
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

                    Person doctor = getDoctorByPesel(pesel);

                    ListSelectedPatientActionListener.reload(doctor);
                    ListSelectedPatientPanel.getPanel().updateDoctor(getDoctorByPesel(pesel));
                    ListSelectedPatientTable.setDoctor(getDoctorByPesel(pesel));
                    System.out.println("changing view to listSelectedPatientPanel");
                    MainView.getCardLayout().show(MainView.getMainPanel(), "listSelectedPatientPanel");
                }
            }
        });
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
