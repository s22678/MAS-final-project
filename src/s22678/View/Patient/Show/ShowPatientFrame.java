package s22678.View.Patient.Show;

import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class ShowPatientFrame extends JFrame {
    public ShowPatientFrame(Person patient) {
        setTitle("Show Details for: patient " + patient.getFirstName() + " " + patient.getLastName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2 ,1));

        ShowPatientTopPanel top = new ShowPatientTopPanel(patient);
        ShowPatientBottomPanel bottom = new ShowPatientBottomPanel(patient);

        panel.add(top);
        panel.add(bottom);


        StartTreatmentButton button = new StartTreatmentButton("Start new treatment", patient);

        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setVisible(true);
    }
}
