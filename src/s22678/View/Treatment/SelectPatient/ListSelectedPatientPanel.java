package s22678.View.Treatment.SelectPatient;

import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.getTextFieldHeight;

public class ListSelectedPatientPanel extends JPanel {
    private final CustomJTextField doctorTextField = new CustomJTextField("", new Dimension(400, getTextFieldHeight()));
    private Person doctor;
    private static ListSelectedPatientPanel thisPanel;
    public ListSelectedPatientPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListSelectedPatientTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);
        JPanel doctorInfo = new JPanel();
        CustomJLabel doctorLabel = new CustomJLabel("Lekarz: ");

        doctorInfo.add(doctorLabel);
        doctorInfo.add(doctorTextField);
        doctorTextField.setEnabled(false);
        doctorTextField.setDisabledTextColor(Color.black);
        this.add(doctorInfo, BorderLayout.NORTH);
        doctorInfo.setPreferredSize(new Dimension(50, 75));

        CustomJButton refreshButton = new ListSelectedPatientRefreshButton("Refresh", this);
        CustomJButton closeButton = new ListSelectedPatientCloseButton("Close");

        buttonContainer.add(refreshButton);
        buttonContainer.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonContainer, BorderLayout.SOUTH);
        buttonContainer.setPreferredSize(new Dimension(50, 75));

        thisPanel = this;
    }

    public static ListSelectedPatientPanel getPanel() {
        return thisPanel;
    }

    public void updateDoctor(Person doctor) {
        if (doctor != null) {
            this.doctor = doctor;
            doctorTextField.setText(doctor.getFirstName() + " " + doctor.getLastName());
        }
    }

    public Person getDoctor() {
        return doctor;
    }
}
