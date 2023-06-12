package s22678.View.Treatment.SelectPatient;

import javax.swing.*;
import java.awt.*;

public class ListSelectedPatientPanel extends JPanel {
    public ListSelectedPatientPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListSelectedPatientTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        JButton refreshButton = new ListSelectedPatientRefreshButton("Refresh");
        JButton closeButton = new ListSelectedPatientCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
    }
}
