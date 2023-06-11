package s22678.View.Equipment.List;

import s22678.Model.Bed;
import s22678.Model.Person;
import s22678.Model.PersonRole;
import s22678.Model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListRoomAndBedTable extends JTable {
    private static DefaultTableModel tableModel;
    public ListRoomAndBedTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(sansSerifFont);
        getTableHeader().setFont(sansSerifFont);
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"Room number", "Is bed occupied", "Patient name"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);


        for (Room room : Room.getExtent()) {
            for (Bed bed : room.getBeds()) {
                tableModel.addRow(
                    new Vector<String>() {{
                        add(String.valueOf(room.getRoomNumber()));
                        add(String.valueOf(bed.isOccupied()));
                        add(bed.isOccupied() ? bed.getPatient().getFirstName() + " " + bed.getPatient().getLastName() : "empty");
                    }}
                );
            }
        }
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
