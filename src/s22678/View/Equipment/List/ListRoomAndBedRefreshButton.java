package s22678.View.Equipment.List;

import s22678.Model.Bed;
import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.Model.Room;

import javax.swing.*;
import java.util.Vector;

public class ListRoomAndBedRefreshButton extends JButton {
    public ListRoomAndBedRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListRoomAndBedTable.getDefaultTableModel().setRowCount(0);
            for (Room room : Room.getExtent()) {
                System.out.println(room.getRoomNumber());
                for (Bed bed : room.getBeds()) {
                    ListRoomAndBedTable.getDefaultTableModel().addRow(
                            new Vector<String>() {{
                                add(String.valueOf(room.getRoomNumber()));
                                add(String.valueOf(bed.isOccupied()));
                                add(bed.isOccupied() ? bed.getPatient().getFirstName() + " " + bed.getPatient().getLastName() : "empty");
                            }}
                    );
                }
            }
        });
    }
}

