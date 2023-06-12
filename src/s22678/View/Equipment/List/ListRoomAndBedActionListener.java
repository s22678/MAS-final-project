package s22678.View.Equipment.List;

import s22678.Model.Bed;
import s22678.Model.Room;

import java.util.Vector;

public class ListRoomAndBedActionListener {
    public static void reload() {
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
    }
}
