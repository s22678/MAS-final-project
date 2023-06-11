package s22678.View.Patient.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;

public class ListPatientRefreshButton extends JButton {
    public ListPatientRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListPatientTable.getDefaultTableModel().setRowCount(0);
            for (Person person : Person.getExtent().values()) {
                if (person.getRole() == PersonRole.PATIENT)
                    ListPatientTable.getDefaultTableModel().addRow(person.getTableData());
            }
        });
    }
}
