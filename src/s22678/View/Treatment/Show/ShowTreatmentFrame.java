package s22678.View.Treatment.Show;

import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.Model.Treatment;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class ShowTreatmentFrame extends JFrame {
    public ShowTreatmentFrame(Treatment treatment) {
        setTitle("Show Details for treatment of: " + treatment.getPatient().getFirstName() + " " + treatment.getPatient().getLastName() + " by: dr " + treatment.getDoctor().getFirstName() + " " + treatment.getDoctor().getLastName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        // Main Panels
        ShowTreatmentTextPanel textPanel = new ShowTreatmentTextPanel(treatment);
        JPanel buttonPanel = new ShowTreatmentButtonPanel(treatment, textPanel);

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}