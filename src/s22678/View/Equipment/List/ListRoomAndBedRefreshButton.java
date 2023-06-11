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
            ListRoomAndBedActionListener.action();
        });
    }
}

