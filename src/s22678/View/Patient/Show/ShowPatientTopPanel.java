package s22678.View.Patient.Show;

import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

public class ShowPatientTopPanel extends JPanel {
    public ShowPatientTopPanel(Person patient) {
        setLayout(new GridLayout(1, 4));
        GridLayout topLayout = new GridLayout(4 ,1);
        topLayout.setVgap(40);
        JPanel leftLeft = new JPanel(topLayout);
        JPanel leftRight = new JPanel(topLayout);
        JPanel rightLeft = new JPanel(topLayout);
        JPanel rightRight = new JPanel(topLayout);

        add(leftLeft);
        add(leftRight);
        add(rightLeft);
        add(rightRight);

        // Add first name
        leftLeft.add(new CustomJLabel("First name:", SwingConstants.CENTER));
        leftRight.add(new CustomJTextField(patient.getFirstName(), false));

        // Add last name
        rightLeft.add(new CustomJLabel("Last name:", SwingConstants.CENTER));
        rightRight.add(new CustomJTextField(patient.getLastName(), false));

        // Add pesel
        leftLeft.add(new CustomJLabel("PESEL:", SwingConstants.CENTER));
        leftRight.add(new CustomJTextField(patient.getPESEL(), false));

        // Add address
        rightLeft.add(new CustomJLabel("Address:", SwingConstants.CENTER));
        rightRight.add(new CustomJTextField(patient.getAddress(), false));

        // Add birthday
        leftLeft.add(new CustomJLabel("Birthday", SwingConstants.CENTER));
        leftRight.add( new CustomJTextField(String.valueOf(patient.getBirthdayDate()), false));

        // Add allergies
        rightLeft.add(new CustomJLabel("Allergies:", SwingConstants.CENTER));
        rightRight.add(new CustomJTextField(patient.getPatientAllergies(), false));

        // Add blood type
        leftLeft.add(new CustomJLabel("Blood Type:", SwingConstants.CENTER));
        leftRight.add(new CustomJTextField(patient.getPatientBloodType(), false));

        // Add admission date
        rightLeft.add(new CustomJLabel("Admission date", SwingConstants.CENTER));
        rightRight.add(new CustomJTextField(patient.getAdmissionDate().toString().substring(0, 16), false));

        // If patient is a minor, add his parents' info
        if (patient.getAge() < 18) {
            topLayout.setRows(topLayout.getRows() + 1);
            leftLeft.add(new CustomJLabel("Parents info:", SwingConstants.CENTER));
            leftRight.add(new CustomJTextField(patient.getPatientParentsInfo(), false));

            rightLeft.add(new CustomJLabel("Parents contact info:", SwingConstants.CENTER));
            rightRight.add(new CustomJTextField(patient.getPatientParentsContactInfo(), false));
        }

        if (patient.isPatientContagious()) {
            topLayout.setRows(topLayout.getRows() + 1);
            leftLeft.add(new CustomJLabel("Contagious:", SwingConstants.CENTER));
            leftRight.add(new CustomJTextField("true", false));
        }
    }
}
