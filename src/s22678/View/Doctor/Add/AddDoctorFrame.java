package s22678.View.Doctor.Add;

import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;
import static s22678.View.Main.MainView.screenWidth;
import static s22678.View.Main.MainView.screenHeight;
import static s22678.View.Main.MainView.textFieldHeight;
import static s22678.View.Main.MainView.textFieldWidth;

public class AddDoctorFrame extends JFrame {


    public AddDoctorFrame() {
        setTitle("Add Doctor");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(8 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);
        JPanel textFieldContainer = new JPanel(labelLayout);

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

        JTextField salaryTextField = new JTextField();
        salaryTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        salaryTextField.setFont(serifFont);

        JTextField specializationTextField = new JTextField();
        specializationTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        specializationTextField.setFont(serifFont);

        JLabel PESELLabel = new CustomJLabel("PESEL", SwingConstants.CENTER);

        JLabel firstNameLabel = new CustomJLabel("First Name", SwingConstants.CENTER);

        JLabel lastNameLabel = new CustomJLabel("Last Name", SwingConstants.CENTER);

        JLabel addressLabel = new CustomJLabel("Address", SwingConstants.CENTER);

        JLabel salaryTypeLabel = new CustomJLabel("Salary", SwingConstants.CENTER);

        JLabel specializationLabel = new CustomJLabel("Specialization", SwingConstants.CENTER);

        JLabel selectFieldsLabel = new CustomJLabel("Select Field(s)", SwingConstants.CENTER);

        DoctorField[] dFields = {DoctorField.SURGEON, DoctorField.DIAGNOSTICIAN};
        JList<DoctorField> fields = new JList<>(dFields);

        fields.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        fields.setVisibleRowCount(2);
        fields.setFont(new Font("Serif,", Font.PLAIN, 21));

        textFieldContainer.add(PESELTextField);
        textFieldContainer.add(firstNameTextField);
        textFieldContainer.add(lastNameTextField);
        textFieldContainer.add(addressTextField);
        textFieldContainer.add(salaryTextField);
        textFieldContainer.add(specializationTextField);
        textFieldContainer.add(fields);

        labelContainer.add(PESELLabel);
        labelContainer.add(firstNameLabel);
        labelContainer.add(lastNameLabel);
        labelContainer.add(addressLabel);
        labelContainer.add(salaryTypeLabel);
        labelContainer.add(specializationLabel);
        labelContainer.add(selectFieldsLabel);

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        JButton addButton = new JButton("Add");
        addButton.setFont(serifFont);
        addButton.addActionListener(e -> {
            if (Person.isBadPESEL(PESELTextField.getText())) {
                JLabel label = new JLabel("incorrect PESEL format");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "PESEL Error", JOptionPane.ERROR_MESSAGE);
            } else if (Person.isTextFieldDataIncorrect(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText())) {
                JLabel label = new JLabel("incorrect doctor info format - cannot be shorter than 2 characters");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Input Data Error", JOptionPane.ERROR_MESSAGE);
            } else if (fields.getSelectedIndices().length < 1) {
                JLabel label = new JLabel("at least 1 field must be selected");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Field Select Error", JOptionPane.ERROR_MESSAGE);
            }else {
                DoctorField[] selectedFields = new DoctorField[fields.getSelectedIndices().length];
                for(int i = 0; i < fields.getSelectedIndices().length; i++) {
                    selectedFields[i] = dFields[i];
                }
                new Person(PESELTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), Integer.parseInt(salaryTextField.getText()), specializationTextField.getText(), selectedFields);

                JLabel label = new JLabel("Doctor " + firstNameTextField.getText() + " " + lastNameTextField.getText() + " added");
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
