package s22678.View.Patient.List;

import s22678.Controller.PatientController;
import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.View.Doctor.Show.ShowDoctorFrame;
import s22678.View.Patient.Show.ShowPatientFrame;
import s22678.View.Patient.Show.ShowPatientHistoryTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static s22678.View.Main.MainView.getSansSerifFont;

public class ListPatientTable extends JTable {
    private static DefaultTableModel tableModel;
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ListPatientTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(getSansSerifFont());
        getTableHeader().setFont(getSansSerifFont());
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"PESEL", "First Name", "Last Name", "Admission Date", "Assigned Doctor"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = getSelectedRow();
                    String pesel = (String) getValueAt(row, 0);

                    Person patient = PatientController.getPatientByPesel(pesel);
                    ShowPatientHistoryTable.reloadData(patient);
                    new ShowPatientFrame(patient);
                }
            }
        });
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
