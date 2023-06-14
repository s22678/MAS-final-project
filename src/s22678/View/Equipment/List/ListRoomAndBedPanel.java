package s22678.View.Equipment.List;

import s22678.View.CustomSwingClasses.CustomJButton;

import javax.swing.*;
import java.awt.*;

public class ListRoomAndBedPanel extends JPanel {
    public ListRoomAndBedPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListRoomAndBedTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        CustomJButton refreshButton = new ListRoomAndBedRefreshButton("Refresh");
        CustomJButton closeButton = new ListRoomAndBedCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        buttonContainer.setPreferredSize(new Dimension(50, 75));
    }
}
