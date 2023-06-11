package s22678.View.Doctor.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

public class ListDoctorActionListener {
    public static void action() {
        ListDoctorTable.getDefaultTableModel().setRowCount(0);
        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.DOCTOR)
                ListDoctorTable.getDefaultTableModel().addRow(person.getDoctorTableData());
        }
    }
}
