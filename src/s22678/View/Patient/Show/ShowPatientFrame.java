package s22678.View.Patient.Show;

import s22678.Model.DoctorField;
import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class ShowPatientFrame extends JFrame {
    public ShowPatientFrame(Person patient) {
        setTitle("Show Details for: patient " + patient.getFirstName() + " " + patient.getLastName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        GridLayout layout = new GridLayout(8 ,4);
        layout.setVgap(40);
        JPanel panel = new JPanel(layout);

        StartTreatmentButton button = new StartTreatmentButton("Start new treatment", patient);




        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        setVisible(true);
    }
}

//    private java.util.List<Treatment> treatments = new ArrayList<>();
//    private java.util.List<String> trainings = new ArrayList<>();
//    private List<String> successfulOperations = new ArrayList<>();
