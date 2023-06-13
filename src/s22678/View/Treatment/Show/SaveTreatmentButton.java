package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static s22678.View.Main.MainView.serifFont;

public class SaveTreatmentButton extends JButton {
    public SaveTreatmentButton(String name, Treatment treatment, ShowTreatmentTextPanel panel) {
        super(name);
        setFont(serifFont);

        addActionListener(e -> {
            List<String> prescribedMedicine = Arrays.asList(panel.getPrescribedDrugsTextField().getText().split(", "));
            String afterTreatmentHealthState = panel.getPatientHealthAfterTreatmentDataTextField().getText();
            System.out.println("save button debug: diseases: " + panel.getDiseasesTextField().getText());
            String disease = panel.getDiseasesTextField().getText();

            treatment.setPrescribedMedicine(prescribedMedicine);
            treatment.setAfterTreatmentHealtState(afterTreatmentHealthState);
            treatment.setDisease(disease);
        });
    }
}
