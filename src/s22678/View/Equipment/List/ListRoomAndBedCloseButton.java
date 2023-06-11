package s22678.View.Equipment.List;

import s22678.View.Main.MainView;

import javax.swing.*;

public class ListRoomAndBedCloseButton extends JButton {
    public ListRoomAndBedCloseButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            System.out.println("changing view");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
