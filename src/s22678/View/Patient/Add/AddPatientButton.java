package s22678.View.Patient.Add;

import s22678.Controller.PersonController;
import s22678.Model.PatientCard;
import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;

public class AddPatientButton extends CustomJButton {
    public AddPatientButton() {
        setText("Add");

        AddPatientTextPanel panel = AddPatientTextPanel.getAddPatientTextPanel();

        addActionListener(e -> {
            Person doctor = getDoctorWithSmallestNumberOfPatients();
            if (doctor == null) JOptionPane.showMessageDialog(this, new CustomJLabel("Patient can't be assigned to a doctor - doctor doesn't exist. Make sure doctors are added to the system"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.isPESELLengthIncorrect(panel.getPESELTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL format"), "PESEL error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.doesPeselExist(panel.getPESELTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("A person with that PESEL already exists in the database"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (Person.isTextFieldDataIncorrect(panel.getFirstNameTextField().getText(), panel.getLastNameTextField().getText(), panel.getAddressTextField().getText(), panel.getBloodTypeTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect patient info format - cannot be shorter than 2 characters"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else {
                System.out.println("new person added: allergies: " + panel.getAllergiesTypeTextField().getText());
                Person person = new Person(panel.getPESELTextField().getText(), panel.getFirstNameTextField().getText(), panel.getLastNameTextField().getText(), panel.getAddressTextField().getText(), panel.getBloodTypeTextField().getText(), panel.getAllergiesTypeTextField().getText(), panel.getIsContagiousRadioButton().isSelected(), new PatientCard());
                if (!person.isPatientAdult()) {
                    person.setPatientParentsInfo(panel.getParentsInfoTextField().getText());
                    person.setPatientParentsContactInfo(panel.getParentsContactInfoTextField().getText());
                }
                new Treatment(doctor, person);
                JOptionPane.showMessageDialog(this, new CustomJLabel("Patient " + panel.getFirstNameTextField().getText() + " " + panel.getLastNameTextField().getText() + " added"));
            }
        });
    }
}
