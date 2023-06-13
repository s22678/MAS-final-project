package s22678.View.Patient.Show;

import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;

import javax.swing.*;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;
import static s22678.View.Main.MainView.serifFont;

public class StartTreatmentButton extends CustomJButton {
    public StartTreatmentButton(String name, Person patient) {
        super(name);

        addActionListener(e -> {
            if (patient.getPatientTreatment() == null) {
                Person doctor = getDoctorWithSmallestNumberOfPatients();
                new Treatment(doctor, patient);
            } else {
                JLabel label = new JLabel("The patient is being trated - cannot start a new treatment");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Multiple treatments error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
