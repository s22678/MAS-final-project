package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

public class EndTreatmentButton extends CustomJButton {
    public EndTreatmentButton(String text, Treatment treatment) {
        super(text);

        addActionListener(e -> {
            treatment.finishTreatment();
            JOptionPane.showMessageDialog(this, new CustomJLabel("Treatment ended"));
        });
    }
}
