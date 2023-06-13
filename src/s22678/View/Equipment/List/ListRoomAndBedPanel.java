package s22678.View.Equipment.List;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ListRoomAndBedPanel extends JPanel {
    public ListRoomAndBedPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListRoomAndBedTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        JButton refreshButton = new ListRoomAndBedRefreshButton("Refresh");
        refreshButton.setFont(serifFont);
        JButton closeButton = new ListRoomAndBedCloseButton("Close");
        closeButton.setFont(serifFont);

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        buttonContainer.setPreferredSize(new Dimension(50, 75));
    }
}
