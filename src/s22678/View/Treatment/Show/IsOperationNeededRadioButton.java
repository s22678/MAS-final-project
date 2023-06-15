package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

import static s22678.View.Main.MainView.getSerifFont;

public class IsOperationNeededRadioButton extends JRadioButton {
    public IsOperationNeededRadioButton(String name, Treatment treatment, JTextField bedTextField) {
        super(name);
        setFont(getSerifFont());
        setSize(150, 150);
        setHorizontalAlignment(JRadioButton.RIGHT);

        addActionListener(e -> {
            if (!treatment.setOperationNeeded(this.isSelected())) {
                JOptionPane.showMessageDialog(this, new CustomJLabel("Patient can't be assigned to a bed - not enough beds. Add more beds"), "Selection error", JOptionPane.ERROR_MESSAGE);
                this.setSelected(false);
            }
            if (treatment.getPatient().getPatientBed() != null) {
                bedTextField.setText(String.valueOf(treatment.getPatient().getPatientBed().getId()));
            } else {
                bedTextField.setText("");
            }
        });
    }
}
