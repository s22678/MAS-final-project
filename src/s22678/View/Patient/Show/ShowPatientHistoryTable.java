package s22678.View.Patient.Show;

import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.Doctor.List.ListDoctorTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static s22678.View.Main.MainView.getSansSerifFont;

public class ShowPatientHistoryTable extends JTable {
    private static final String[] columnNames = {"Treatment Start", "Treatment End", "Disease", "Prescribed medicine", "Assigned Doctor"};
    private static DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public ShowPatientHistoryTable(Person patient) {
        setRowHeight(this.getRowHeight() + 35);
        setFont(getSansSerifFont());
        getTableHeader().setFont(getSansSerifFont());
        getTableHeader().setResizingAllowed(true);
        setModel(tableModel);
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }

    public static void reloadData(Person patient) {
        ShowPatientHistoryTable.getDefaultTableModel().setRowCount(0);
        for (Treatment treatment : patient.getPatientCard().getPatientHistory()) {
            ShowPatientHistoryTable.getDefaultTableModel().addRow(treatment.getTreatmentTableData());
        }
    }
}
