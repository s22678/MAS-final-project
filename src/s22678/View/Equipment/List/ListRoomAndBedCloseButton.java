package s22678.View.Equipment.List;

import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.Main.MainView;

public class ListRoomAndBedCloseButton extends CustomJButton {
    public ListRoomAndBedCloseButton(String text) {
        super(text);

        addActionListener(e -> {
            System.out.println("changing view to defaultPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
