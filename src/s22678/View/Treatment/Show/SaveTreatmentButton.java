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
            List<String> prescribedMedicine = Arrays.asList(panel.getPrescribedDrugsTextField().getText().split(", "));
            String afterTreatmentHealthState = panel.getPatientHealthAfterTreatmentDataTextField().getText();
            System.out.println("save button debug: diseases: " + panel.getDiseasesTextField().getText());
            String disease = panel.getDiseasesTextField().getText();

            treatment.setPrescribedMedicine(prescribedMedicine);
            treatment.setAfterTreatmentHealthState(afterTreatmentHealthState);
            treatment.setDisease(disease);
            JOptionPane.showMessageDialog(this, new CustomJLabel("Patient data saved (temporarily, save to file to store permanently)"));
        });
    }
}
