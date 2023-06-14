package s22678.View.Doctor.Add;

import s22678.Controller.PersonController;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

public class AddDoctorButton extends CustomJButton {
    public AddDoctorButton() {
        setText("Add");

        AddDoctorTextPanel panel = AddDoctorTextPanel.getAddDoctorTextPanel();

        addActionListener(e -> {
            if (PersonController.isPESELLengthIncorrect(panel.getPESELTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL length"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.doesPeselExist(panel.getPESELTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("A person with that PESEL already exists in the database"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else if (PersonController.isPESELIncorrectlyFormated(panel.getPESELTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect PESEL format - cannot translate to date"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (Person.isTextFieldDataIncorrect(panel.getFirstNameTextField().getText(), panel.getLastNameTextField().getText(), panel.getAddressTextField().getText())) JOptionPane.showMessageDialog(this, new CustomJLabel("incorrect doctor info format - cannot be shorter than 2 characters"), "Input Data Error", JOptionPane.ERROR_MESSAGE);
            else if (panel.getFields().getSelectedIndices().length < 1) JOptionPane.showMessageDialog(this, new CustomJLabel("at least 1 field must be selected"), "Field Select Error", JOptionPane.ERROR_MESSAGE);
            else {
                DoctorField[] selectedFields = new DoctorField[panel.getFields().getSelectedIndices().length];
                int i = 0;
                for (Integer fieldNumber : panel.getFields().getSelectedIndices()) {
                    selectedFields[i++] = panel.getdFields()[fieldNumber];
                }
                new Person(panel.getPESELTextField().getText(), panel.getFirstNameTextField().getText(), panel.getLastNameTextField().getText(), panel.getAddressTextField().getText(), Integer.parseInt(panel.getSalaryTextField().getText()), panel.getSpecializationTextField().getText(), selectedFields);

                JOptionPane.showMessageDialog(this, new CustomJLabel("Doctor " + panel.getFirstNameTextField().getText() + " " + panel.getLastNameTextField().getText() + " added"));
            }
        });
    }
}
