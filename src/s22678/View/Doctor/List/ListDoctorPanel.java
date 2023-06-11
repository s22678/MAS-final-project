package s22678.View.Doctor.List;

import javax.swing.*;
import java.awt.*;

public class ListDoctorPanel extends JPanel {
    public ListDoctorPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListDoctorTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        JButton refreshButton = new ListDoctorRefreshButton("Refresh");
        JButton closeButton = new ListDoctorCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
    }
}
