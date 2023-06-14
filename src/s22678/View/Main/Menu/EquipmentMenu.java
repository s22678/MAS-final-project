package s22678.View.Main.Menu;

import s22678.Model.Room;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.Equipment.Add.AddBedFrame;
import s22678.View.Equipment.List.ListRoomAndBedActionListener;
import s22678.View.Main.MainView;

import javax.swing.*;

import static s22678.View.Main.MainView.getSerifFont;

public class EquipmentMenu extends JMenu {
    public EquipmentMenu(String name) {
        super(name);
        setFont(getSerifFont());
        JMenuItem showRoomItem = new JMenuItem("List Rooms and Beds");
        showRoomItem.setFont(getSerifFont());
        showRoomItem.addActionListener(e -> {
            System.out.println("changing view to listRoomAndBedPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listRoomAndBedPanel");
            ListRoomAndBedActionListener.reload();
        });
        JMenuItem addRoomItem = new JMenuItem("Add Room");
        addRoomItem.setFont(getSerifFont());
        addRoomItem.addActionListener(e -> {
            Room room = new Room();
            JOptionPane.showMessageDialog(this, new CustomJLabel("Room nr: " + room.getRoomNumber() + " added"));
        });
        JMenuItem addBedItem = new JMenuItem("Add Bed");
        addBedItem.setFont(getSerifFont());
        addBedItem.addActionListener(e -> {
            JFrame addBedWindow = new AddBedFrame();
            addBedWindow.setVisible(true);
        });

        add(showRoomItem);
        add(addRoomItem);
        add(addBedItem);
    }
}
