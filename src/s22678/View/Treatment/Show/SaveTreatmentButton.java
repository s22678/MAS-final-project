package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class SaveTreatmentButton extends CustomJButton {
    public SaveTreatmentButton(String text, Treatment treatment, ShowTreatmentTextPanel panel) {
        super(text);

        addActionListener(e -> {
            SaveTreatmentData.save(panel, treatment);
            JOptionPane.showMessageDialog(this, new CustomJLabel("Patient data saved (temporarily, save to file to store permanently)"));
        });
    }
}
