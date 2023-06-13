package s22678.View.Treatment.SelectPatient;

import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.Doctor.Show.ShowDoctorFrame;
import s22678.View.Treatment.Show.ShowTreatmentFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListSelectedPatientTable extends JTable {
    private static Person doctor;
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = getSelectedRow();
                    String pesel = (String) getValueAt(row, 0);

                    for (Treatment treatment : doctor.getDoctorTreatments()) {
                        if (treatment.getPatient().getPESEL().equals(pesel)) {
                            new ShowTreatmentFrame(treatment);
                            break;
                        }
                    }
                }
            }
        });
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }

    public static void setDoctor(Person person) {
        doctor = person;
    }
}
