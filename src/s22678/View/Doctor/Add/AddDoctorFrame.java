package s22678.View.Doctor.Add;

import s22678.Controller.PersonController;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class AddDoctorFrame extends JFrame {


    public AddDoctorFrame() {
        setTitle("Add Doctor");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(8 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);
        JPanel textFieldContainer = new JPanel(labelLayout);

        JTextField PESELTextField = new CustomJTextField();
        JTextField firstNameTextField = new CustomJTextField();
        JTextField lastNameTextField = new CustomJTextField();
        JTextField addressTextField = new CustomJTextField();
        JTextField salaryTextField = new CustomJTextField();
        JTextField specializationTextField = new CustomJTextField();

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
        textFieldContainer.add(add(new JSeparator()));

        labelContainer.add(new CustomJLabel("PESEL", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("First Name", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Last Name", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Address", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Salary", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Specialization", SwingConstants.CENTER));
        labelContainer.add(new CustomJLabel("Select Field(s)", SwingConstants.CENTER));
        labelContainer.add(add(new JSeparator()));

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        CustomJButton addButton = new CustomJButton("Add");
        addButton.addActionListener(e -> {
            if (PersonController.isPESELLengthIncorrect(PESELTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL length"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.doesPeselExist(PESELTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("A person with that PESEL already exists in the database"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.isPESELIncorrectlyFormated(PESELTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL format - cannot translate to date"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (Person.isTextFieldDataIncorrect(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect doctor info format - cannot be shorter than 2 characters"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (fields.getSelectedIndices().length < 1) JOptionPane.showMessageDialog(this, new CustomJLabel("at least 1 field must be selected"), "Field Select Error", JOptionPane.ERROR_MESSAGE);
            else {
                DoctorField[] selectedFields = new DoctorField[fields.getSelectedIndices().length];
                for(int i = 0; i < fields.getSelectedIndices().length; i++) {
                    selectedFields[i] = dFields[i];
                }
                new Person(PESELTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), Integer.parseInt(salaryTextField.getText()), specializationTextField.getText(), selectedFields);

                JOptionPane.showMessageDialog(this, new CustomJLabel("Doctor " + firstNameTextField.getText() + " " + lastNameTextField.getText() + " added"));
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
