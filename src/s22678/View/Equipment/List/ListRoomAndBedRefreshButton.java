package s22678.View.Equipment.List;

import javax.swing.*;

public class ListRoomAndBedRefreshButton extends JButton {
    public ListRoomAndBedRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListRoomAndBedActionListener.reload();
        });
    }
}

