package s22678.View.Treatment.SelectDoctor;

import s22678.Controller.DoctorController;
import s22678.Model.Person;
import s22678.Model.PersonRole;

public class ListDoctorWithPatientActionListener {
    public static void reload() {
        ListDoctorWithPatientTable.getDefaultTableModel().setRowCount(0);
        for (Person person : DoctorController.getDoctorsWithPatients()) {
            if (person.getRole() == PersonRole.DOCTOR)
                ListDoctorWithPatientTable.getDefaultTableModel().addRow(person.getDoctorTableData());
        }
    }
}
