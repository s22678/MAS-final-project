package s22678.View.Doctor.List;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ListDoctorPanel extends JPanel {
    public ListDoctorPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListDoctorTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        JButton refreshButton = new ListDoctorRefreshButton("Refresh");
        refreshButton.setFont(serifFont);
        JButton closeButton = new ListDoctorCloseButton("Close");
        closeButton.setFont(serifFont);

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        buttonContainer.setPreferredSize(new Dimension(50, 75));
    }
}
