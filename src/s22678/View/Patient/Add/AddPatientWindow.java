package s22678.View.Patient.Add;

import s22678.Model.PatientCard;
import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;

import static s22678.View.Main.MainView.*;

public class AddPatientWindow extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;

    public AddPatientWindow() {
        setTitle("Add Patient");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(8 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);

        GridLayout textFieldLayout = new GridLayout(8 ,1);
        textFieldLayout.setVgap(40);
        JPanel textFieldContainer = new JPanel(textFieldLayout);

        JTextField PESELTextField = new JTextField();
        PESELTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        PESELTextField.setFont(serifFont);

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

        JTextField parentsInfoTextField = new JTextField();
        parentsInfoTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        parentsInfoTextField.setFont(serifFont);

        JTextField parentsContactInfoTextField = new JTextField();
        parentsContactInfoTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        parentsContactInfoTextField.setFont(serifFont);

        JLabel PESELLabel = new JLabel("PESEL", SwingConstants.CENTER);
        PESELLabel.setFont(serifFont);

        JLabel firstNameLabel = new JLabel("First Name", SwingConstants.CENTER);
        firstNameLabel.setFont(serifFont);

        JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.CENTER);
        lastNameLabel.setFont(serifFont);

        JLabel addressLabel = new JLabel("Address", SwingConstants.CENTER);
        addressLabel.setFont(serifFont);

        JLabel bloodTypeLabel = new JLabel("Blood Type", SwingConstants.CENTER);
        bloodTypeLabel.setFont(serifFont);

        JLabel parentsInfoLabel = new JLabel("Parents Info", SwingConstants.CENTER);
        parentsInfoLabel.setFont(serifFont);

        JLabel parentsContactLabel = new JLabel("Parents Contact Info", SwingConstants.CENTER);
        parentsContactLabel.setFont(serifFont);

        JRadioButton isContagiousRadioButton = new JRadioButton("Is contagious?");
        isContagiousRadioButton.setFont(serifFont);
        isContagiousRadioButton.setSize(70, 70);
        isContagiousRadioButton.setHorizontalAlignment(JRadioButton.CENTER);

        textFieldContainer.add(PESELTextField);
        textFieldContainer.add(firstNameTextField);
        textFieldContainer.add(lastNameTextField);
        textFieldContainer.add(addressTextField);
        textFieldContainer.add(bloodTypeTextField);
        textFieldContainer.add(parentsInfoTextField);
        textFieldContainer.add(parentsContactInfoTextField);

        labelContainer.add(PESELLabel);
        labelContainer.add(firstNameLabel);
        labelContainer.add(lastNameLabel);
        labelContainer.add(addressLabel);
        labelContainer.add(bloodTypeLabel);
        labelContainer.add(parentsInfoLabel);
        labelContainer.add(parentsContactLabel);
        labelContainer.add(isContagiousRadioButton);

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            if (!Person.parsePESEL(PESELTextField.getText())) {
                JLabel label = new JLabel("incorrect PESEL format");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "PESEL error", JOptionPane.ERROR_MESSAGE);
            } else if (!Person.parseTextFields(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), bloodTypeTextField.getText())) {
                JLabel label = new JLabel("incorrect patient info format - cannot be shorter than 2 characters");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Input Data error", JOptionPane.ERROR_MESSAGE);
            } else {
                Person person = new Person(PESELTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), bloodTypeTextField.getText(), isContagiousRadioButton.isSelected(), new PatientCard());
                if (!person.isPatientAdult()) {
                    person.setPatientParentsInfo(parentsInfoTextField.getText());
                    person.setPatientParentsContactInfo(parentsContactInfoTextField.getText());
                }
                JLabel label = new JLabel("Patient " + firstNameTextField.getText() + " " + lastNameTextField.getText() + " added");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label);
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
