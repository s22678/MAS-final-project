package s22678.View.Main.Menu;

import s22678.Model.Room;
import s22678.View.Equipment.Add.AddBedWindow;
import s22678.View.Equipment.List.ListRoomAndBedActionListener;
import s22678.View.Main.MainView;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class EquipmentMenu extends JMenu {
    public EquipmentMenu(String name) {
        super(name);
        setFont(serifFont);
        JMenuItem showRoomItem = new JMenuItem("List Rooms and Beds");
        showRoomItem.setFont(serifFont);
        showRoomItem.addActionListener(e -> {
            System.out.println("changing view to listRoomAndBedPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listRoomAndBedPanel");
            ListRoomAndBedActionListener.action();
        });
        JMenuItem addRoomItem = new JMenuItem("Add Room");
        addRoomItem.setFont(serifFont);
        addRoomItem.addActionListener(e -> {
            Room room = new Room();
            JOptionPane.showMessageDialog(this, "Room nr: " + room.getRoomNumber() + " added");
        });
        JMenuItem addBedItem = new JMenuItem("Add Bed");
        addBedItem.setFont(serifFont);
        addBedItem.addActionListener(e -> {
            JFrame addBedWindow = new AddBedWindow();
            addBedWindow.setVisible(true);
        });

        add(showRoomItem);
        add(addRoomItem);
        add(addBedItem);
    }
}
