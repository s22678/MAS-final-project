package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class SaveTreatmentData {
    public static void save(ShowTreatmentTextPanel panel, Treatment treatment) {
        List<String> prescribedMedicine = Arrays.asList(panel.getPrescribedDrugsTextField().getText().split(", "));
        String afterTreatmentHealthState = panel.getPatientHealthAfterTreatmentDataTextField().getText();
        System.out.println("save button debug: diseases: " + panel.getDiseasesTextField().getText());
        String disease = panel.getDiseasesTextField().getText();

        treatment.setPrescribedMedicine(prescribedMedicine);
        treatment.setAfterTreatmentHealthState(afterTreatmentHealthState);
        treatment.setDisease(disease);
    }
}
