package s22678.View.Treatment.SelectDoctor;

import s22678.View.CustomSwingClasses.CustomJButton;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ListDoctorWithPatientPanel extends JPanel {
    public ListDoctorWithPatientPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListDoctorWithPatientTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        CustomJButton refreshButton = new ListDoctorWithPatientRefreshButton("Refresh");
        CustomJButton closeButton = new ListDoctorWithPatientCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        buttonContainer.setPreferredSize(new Dimension(50, 75));
    }
}
