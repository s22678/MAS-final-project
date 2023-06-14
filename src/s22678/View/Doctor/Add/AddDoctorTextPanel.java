package s22678.View.Doctor.Add;

import s22678.Model.DoctorField;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

public class AddDoctorTextPanel extends JPanel {
    private final CustomJTextField PESELTextField;
    private final CustomJTextField firstNameTextField;
    private final CustomJTextField lastNameTextField;
    private final CustomJTextField addressTextField;
    private final CustomJTextField salaryTextField;
    private final CustomJTextField specializationTextField;
    private final DoctorField[] dFields = {DoctorField.SURGEON, DoctorField.DIAGNOSTICIAN};
    private final JList<DoctorField> fields;
    private static AddDoctorTextPanel thisObj;

    public AddDoctorTextPanel() {
        setLayout(new GridLayout(1 ,2));

        GridLayout gridLayout = new GridLayout(8 ,1);
        gridLayout.setVgap(40);
        JPanel labelContainer = new JPanel(gridLayout);
        JPanel textFieldContainer = new JPanel(gridLayout);

        PESELTextField = new CustomJTextField();
        firstNameTextField = new CustomJTextField();
        lastNameTextField = new CustomJTextField();
        addressTextField = new CustomJTextField();
        salaryTextField = new CustomJTextField();
        specializationTextField = new CustomJTextField();

        fields = new JList<>(dFields);

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

        add(labelContainer);
        add(textFieldContainer);

        thisObj = this;
    }

    public static AddDoctorTextPanel getAddDoctorTextPanel() {
        return thisObj;
    }

    public CustomJTextField getPESELTextField() {
        return PESELTextField;
    }

    public CustomJTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public CustomJTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public CustomJTextField getAddressTextField() {
        return addressTextField;
    }

    public CustomJTextField getSalaryTextField() {
        return salaryTextField;
    }

    public CustomJTextField getSpecializationTextField() {
        return specializationTextField;
    }

    public DoctorField[] getdFields() {
        return dFields;
    }

    public JList<DoctorField> getFields() {
        return fields;
    }
}
