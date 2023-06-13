package s22678.View.Equipment.List;

import s22678.View.CustomSwingClasses.CustomJButton;

public class ListRoomAndBedRefreshButton extends CustomJButton {
    public ListRoomAndBedRefreshButton(String text) {
        super(text);

        addActionListener(e -> {
            ListRoomAndBedActionListener.reload();
        });
    }
}

