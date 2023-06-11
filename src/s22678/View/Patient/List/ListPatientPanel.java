package s22678.View.Patient.List;

import javax.swing.*;
import java.awt.*;

public class ListPatientPanel extends JPanel {
    public ListPatientPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListPatientTable());

        JPanel buttonContainer = new JPanel(new GridLayout(1, 2));
        JButton refreshButton = new ListPatientRefreshButton("Refresh");
        JButton closeButton = new ListPatientCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
    }
}