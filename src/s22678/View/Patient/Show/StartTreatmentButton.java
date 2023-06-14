package s22678.View.Patient.Show;

import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;

public class StartTreatmentButton extends CustomJButton {
    public StartTreatmentButton(String name, Person patient) {
        super(name);

        addActionListener(e -> {
            if (patient.getPatientTreatment() == null) {
                Person doctor = getDoctorWithSmallestNumberOfPatients();
                new Treatment(doctor, patient);
                JOptionPane.showMessageDialog(this, new CustomJLabel("Patient " + patient.getFirstName() + " " + patient.getLastName() + " is being treated by dr " + doctor.getFirstName() + doctor.getLastName()));
            } else {
                JOptionPane.showMessageDialog(this, new CustomJLabel("The patient is being treated - cannot start a new treatment"), "Multiple treatments error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
