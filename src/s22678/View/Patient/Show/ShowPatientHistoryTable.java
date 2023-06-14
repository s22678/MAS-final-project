package s22678.View.Patient.Show;

import s22678.Model.PatientCard;
import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.Model.Treatment;
import s22678.View.Doctor.List.ListDoctorTable;
import s22678.View.Doctor.Show.ShowDoctorFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static s22678.View.Main.MainView.getSansSerifFont;

public class ShowPatientHistoryTable extends JTable {
    private static DefaultTableModel tableModel;

    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ShowPatientHistoryTable(Person patient) {
        setRowHeight(this.getRowHeight() + 35);
        setFont(getSansSerifFont());
        getTableHeader().setFont(getSansSerifFont());
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"Treatment Start", "Treatment End", "Disease", "Prescribed medicine"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        tableModel.setRowCount(0);
        for (Treatment treatment : patient.getPatientCard().getPatientHistory()) {
            ListDoctorTable.getDefaultTableModel().addRow(treatment.getTreatmentTableData());
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    tableModel.setRowCount(0);
                    for (Treatment treatment : patient.getPatientCard().getPatientHistory()) {
                            ListDoctorTable.getDefaultTableModel().addRow(treatment.getTreatmentTableData());
                    }
                }
            }
        });
    }
}
