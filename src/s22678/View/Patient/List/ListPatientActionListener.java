package s22678.View.Patient.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

public class ListPatientActionListener {
    public static void reload() {
        ListPatientTable.getDefaultTableModel().setRowCount(0);
        for (Person person : Person.getExtent().values()) {
            if (person.getCurrentRole() == PersonRole.PATIENT)
                ListPatientTable.getDefaultTableModel().addRow(person.getPatientTableData());
        }
    }
}
