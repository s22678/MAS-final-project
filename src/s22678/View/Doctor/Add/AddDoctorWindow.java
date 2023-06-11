package s22678.View.Doctor.Add;

import s22678.Model.DoctorField;
import s22678.Model.PatientCard;
import s22678.Model.Person;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static s22678.View.Main.MainView.serifFont;

public class AddDoctorWindow extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;

    public AddDoctorWindow() {
        setTitle("Add Doctor");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(7 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);

        GridLayout textFieldLayout = new GridLayout(7 ,1);
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

        JTextField salaryTextField = new JTextField();
        salaryTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        salaryTextField.setFont(serifFont);

        JTextField specializationTextField = new JTextField();
        specializationTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        specializationTextField.setFont(serifFont);

        JLabel PESELLabel = new JLabel("PESEL", SwingConstants.CENTER);
        PESELLabel.setFont(serifFont);

        JLabel firstNameLabel = new JLabel("First Name", SwingConstants.CENTER);
        firstNameLabel.setFont(serifFont);

        JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.CENTER);
        lastNameLabel.setFont(serifFont);

        JLabel addressLabel = new JLabel("Address", SwingConstants.CENTER);
        addressLabel.setFont(serifFont);

        JLabel salaryTypeLabel = new JLabel("Salary", SwingConstants.CENTER);
        salaryTypeLabel.setFont(serifFont);

        JLabel specializationLabel = new JLabel("Specialization", SwingConstants.CENTER);
        specializationLabel.setFont(serifFont);

        JLabel selectFieldsLabel = new JLabel("Select Field(s)", SwingConstants.CENTER);
        selectFieldsLabel.setFont(serifFont);

        DoctorField[] dFields = {DoctorField.SURGEON, DoctorField.DIAGNOSTICIAN};
        JList<DoctorField> fields = new JList<>(dFields);
        // TODO: Check list selection model
        fields.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        fields.setVisibleRowCount(2);
        fields.setFont(serifFont);

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
        addButton.addActionListener(e -> {
            if (!Person.parsePESEL(PESELTextField.getText())) {
                JOptionPane.showMessageDialog(this, "incorrect PESEL format", "PESEL Error", JOptionPane.ERROR_MESSAGE);
            } else if (!Person.parseTextFields(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText())) {
                JOptionPane.showMessageDialog(this, "incorrect doctor info format - cannot be shorter than 2 characters", "Input Data Error", JOptionPane.ERROR_MESSAGE);
            } else if (fields.getSelectedIndices().length < 1) {
                JOptionPane.showMessageDialog(this, "at least 1 field must be selected", "Field Select Error", JOptionPane.ERROR_MESSAGE);
            }else {
                DoctorField[] selectedFields = new DoctorField[fields.getSelectedIndices().length];
                for(int i = 0; i < fields.getSelectedIndices().length; i++) {
                    selectedFields[i] = dFields[i];
                }

                new Person(PESELTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), Integer.parseInt(salaryTextField.getText()), specializationTextField.getText(), selectedFields);
                JOptionPane.showMessageDialog(this, "Doctor " + firstNameTextField.getText() + " " + lastNameTextField.getText() + " added");
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
