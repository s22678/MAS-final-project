package s22678.View.Patient.Add;

import s22678.Controller.PersonController;
import s22678.Model.PatientCard;
import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJRadioButton;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;
import static s22678.View.Main.MainView.*;

public class AddPatientFrame extends JFrame {

    public AddPatientFrame() {
        setTitle("Add Patient");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(9 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);

        GridLayout textFieldLayout = new GridLayout(9 ,1);
        textFieldLayout.setVgap(40);
        JPanel textFieldContainer = new JPanel(textFieldLayout);

        CustomJTextField PESELTextField = new CustomJTextField();

        JTextField firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        firstNameTextField.setFont(serifFont);

        JTextField lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        lastNameTextField.setFont(serifFont);

        JTextField addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        addressTextField.setFont(serifFont);

        JTextField bloodTypeTextField = new JTextField();
        bloodTypeTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        bloodTypeTextField.setFont(serifFont);

        JTextField allergiesTypeTextField = new JTextField();
        allergiesTypeTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        allergiesTypeTextField.setFont(serifFont);

        JTextField parentsInfoTextField = new JTextField();
        parentsInfoTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        parentsInfoTextField.setFont(serifFont);

        JTextField parentsContactInfoTextField = new JTextField();
        parentsContactInfoTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        parentsContactInfoTextField.setFont(serifFont);

        CustomJRadioButton isContagiousRadioButton = new CustomJRadioButton("Is contagious?", JRadioButton.CENTER);

        textFieldContainer.add(PESELTextField);
        textFieldContainer.add(firstNameTextField);
        textFieldContainer.add(lastNameTextField);
        textFieldContainer.add(addressTextField);
        textFieldContainer.add(bloodTypeTextField);
        textFieldContainer.add(allergiesTypeTextField);
        textFieldContainer.add(parentsInfoTextField);
        textFieldContainer.add(parentsContactInfoTextField);

        labelContainer.add(new CustomJLabel("PESEL", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("First Name", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Last Name", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Address", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Blood Type", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Allergies", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Parents Info", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Parents Contact Info", SwingConstants.CENTER));
        labelContainer.add(isContagiousRadioButton);

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        CustomJButton addButton = new CustomJButton("Add");
        addButton.addActionListener(e -> {
            Person doctor = getDoctorWithSmallestNumberOfPatients();
            if (doctor == null) JOptionPane.showMessageDialog(this, new CustomJLabel("Patient can't be assigned to a doctor - doctor doesn't exist. Make sure doctors are added to the system"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.isPESELLengthIncorrect(PESELTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL format"), "PESEL error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.doesPeselExist(PESELTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("A person with that PESEL already exists in the database"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (Person.isTextFieldDataIncorrect(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), bloodTypeTextField.getText())) {
                JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect patient info format - cannot be shorter than 2 characters"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("new person added: allergies: " + allergiesTypeTextField.getText());
                Person person = new Person(PESELTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), bloodTypeTextField.getText(), allergiesTypeTextField.getText(), isContagiousRadioButton.isSelected(), new PatientCard());
                if (!person.isPatientAdult()) {
                    person.setPatientParentsInfo(parentsInfoTextField.getText());
                    person.setPatientParentsContactInfo(parentsContactInfoTextField.getText());
                }
                new Treatment(doctor, person);
                JOptionPane.showMessageDialog(this, new CustomJLabel("Patient " + firstNameTextField.getText() + " " + lastNameTextField.getText() + " added"));
            }
        });

        buttonPanel.add(addButton);

        masterPanel.add(labelContainer);
        masterPanel.add(textFieldContainer);

        add(masterPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
