package s22678.View.Patient.Add;

import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJRadioButton;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

public class AddPatientTextPanel extends JPanel {
    private final CustomJTextField PESELTextField;
    private final CustomJTextField firstNameTextField;
    private final CustomJTextField lastNameTextField;
    private final CustomJTextField addressTextField;
    private final CustomJTextField bloodTypeTextField;
    private final CustomJTextField allergiesTypeTextField;
    private final CustomJTextField parentsInfoTextField;
    private final CustomJTextField parentsContactInfoTextField;
    private final CustomJRadioButton isContagiousRadioButton;

    private static AddPatientTextPanel thisObj;
    public AddPatientTextPanel() {
        setLayout(new GridLayout(1 ,2));

        GridLayout layout = new GridLayout(9 ,1);
        layout.setVgap(40);
        JPanel labelContainer = new JPanel(layout);
        JPanel textFieldContainer = new JPanel(layout);

        PESELTextField = new CustomJTextField();
        firstNameTextField = new CustomJTextField();
        lastNameTextField = new CustomJTextField();
        addressTextField = new CustomJTextField();
        bloodTypeTextField = new CustomJTextField();
        allergiesTypeTextField = new CustomJTextField();
        parentsInfoTextField = new CustomJTextField();
        parentsContactInfoTextField = new CustomJTextField();

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

        isContagiousRadioButton = new CustomJRadioButton("Is contagious?", JRadioButton.CENTER);
        labelContainer.add(isContagiousRadioButton);

        add(labelContainer);
        add(textFieldContainer);

        thisObj = this;
    }

    public static AddPatientTextPanel getAddPatientTextPanel() {
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

    public CustomJTextField getBloodTypeTextField() {
        return bloodTypeTextField;
    }

    public CustomJTextField getAllergiesTypeTextField() {
        return allergiesTypeTextField;
    }

    public CustomJTextField getParentsInfoTextField() {
        return parentsInfoTextField;
    }

    public CustomJTextField getParentsContactInfoTextField() {
        return parentsContactInfoTextField;
    }

    public CustomJRadioButton getIsContagiousRadioButton() {
        return isContagiousRadioButton;
    }
}
