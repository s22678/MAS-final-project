package s22678.View.Doctor.Show;

import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.View.Doctor.List.ListDoctorTable;

public class ShowTreatmentActionListener {
    public static void action() {
        ShowTreatmentTable.getDefaultTableModel().setRowCount(0);
        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.PATIENT)
                ShowTreatmentTable.getDefaultTableModel().addRow(person.getDoctorTableData());
        }
    }
}
