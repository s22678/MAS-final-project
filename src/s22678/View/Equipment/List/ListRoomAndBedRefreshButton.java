package s22678.View.Equipment.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;

public class ListRoomAndBedRefreshButton extends JButton {
    public ListRoomAndBedRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListRoomAndBedTable.getDefaultTableModel().setRowCount(0);
            for (Person person : Person.getExtent().values()) {
                if (person.getRole() == PersonRole.DOCTOR)
                    ListRoomAndBedTable.getDefaultTableModel().addRow(person.getDoctorTableData());
            }
        });
    }
}
