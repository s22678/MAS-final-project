package s22678.View.Treatment.SelectPatient;

import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.Model.Treatment;

import java.util.List;

public class ListSelectedPatientActionListener {
    public static void reload(Person doctor) {
        ListSelectedPatientTable.getDefaultTableModel().setRowCount(0);
        for (Treatment treatment : doctor.getDoctorTreatments()) {
            ListSelectedPatientTable.getDefaultTableModel().addRow(treatment.getPatient().getPatientTableData());
        }
    }
}
