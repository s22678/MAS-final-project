package s22678.View.Doctor.Show;

import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;

public class ShowDoctorChangeSalaryButton extends CustomJButton {
    public ShowDoctorChangeSalaryButton(Person doctor, CustomJTextField salaryTextField) {
        setText("Set Salary");

        addActionListener(e -> {
            doctor.setDoctorSalary(Integer.parseInt(salaryTextField.getText()));
            JOptionPane.showMessageDialog(this, new CustomJLabel("Doctor " + doctor.getFirstName() + " " + doctor.getLastName() + " changed"));
        });
    }
}
