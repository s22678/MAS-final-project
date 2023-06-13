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
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        // Main Panels
        JPanel textPanel = new ShowTreatmentTextPanel(treatment);
        JPanel buttonPanel = new ShowTreatmentButtonPanel();

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}

//    private java.util.List<Treatment> treatments = new ArrayList<>();
//    private java.util.List<String> trainings = new ArrayList<>();
//    private List<String> successfulOperations = new ArrayList<>();
