package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;

public class EndTreatmentButton extends CustomJButton {
    public EndTreatmentButton(String text, Treatment treatment, ShowTreatmentTextPanel panel) {
        super(text);

        addActionListener(e -> {
            if (panel.getDiseasesTextField().getText().length() == 0  || panel.getPrescribedDrugsTextField().getText().length() == 0 || panel.getPatientHealthAfterTreatmentDataTextField().getText().length() == 0) JOptionPane.showMessageDialog(this, new CustomJLabel("Diseases, prescribed drugs and patient health after treatment must be filled in before ending the treatment"), "Input Data error", JOptionPane.ERROR_MESSAGE);
            else {
                treatment.finishTreatment();
                panel.setTreatmentEndTextField(treatment.getTreatmentEnd().toString());
                JOptionPane.showMessageDialog(this, new CustomJLabel("Treatment ended"));
            }
        });
    }
}
