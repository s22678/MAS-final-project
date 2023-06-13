package s22678.View.Treatment.SelectPatient;

import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ListSelectedPatientPanel extends JPanel {
    private JPanel doctorInfo = new JPanel();
    private JLabel doctorLabel = new JLabel("Lekarz: ");
    private JTextField doctorTextField = new JTextField();
    private static ListSelectedPatientPanel thisPanel;
    public ListSelectedPatientPanel() {
        setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(new ListSelectedPatientTable());

        GridLayout buttonContainerLayout = new GridLayout(1, 2);
        buttonContainerLayout.setHgap(30);
        JPanel buttonContainer = new JPanel(buttonContainerLayout);

        JButton refreshButton = new ListSelectedPatientRefreshButton("Refresh");
        refreshButton.setFont(serifFont);
        JButton closeButton = new ListSelectedPatientCloseButton("Close");
        closeButton.setFont(serifFont);

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

            doctorLabel.setFont(serifFont);
            JTextField doctorTextField = new JTextField(doctor.getFirstName() + " " + doctor.getLastName());
            doctorTextField.setFont(serifFont);

            doctorInfo.add(doctorLabel);
            doctorInfo.add(doctorTextField);
            this.add(doctorInfo, BorderLayout.NORTH);
            doctorInfo.setPreferredSize(new Dimension(50, 75));
        }
    }
}
