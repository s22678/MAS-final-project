package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;


public class ShowTreatmentTextPanel extends JPanel {
    private final CustomJTextField diseasesTextField;
    private final CustomJTextField prescribedDrugsTextField;
    private final CustomJTextField patientHealthAfterTreatmentDataTextField;
    private final CustomJTextField treatmentEndTextField;

    public ShowTreatmentTextPanel(Treatment treatment) {

        GridLayout mainLayout = new GridLayout(7 ,4);
        mainLayout.setVgap(40);
        setLayout(mainLayout);


        // First Row
        // Add doctor full name to JPanel
        add(new CustomJLabel("Doctor:", SwingConstants.CENTER));

        // Doctor full name data textField
        CustomJTextField doctorNameTextField = new CustomJTextField(treatment.getDoctor().getFirstName() + " " + treatment.getDoctor().getLastName(), false);
        doctorNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        // Add doctor full name data to JPanel
        add(doctorNameTextField);

        // Add patient full name to JPanel
        add(new CustomJLabel("Patient:", SwingConstants.CENTER));

        // Patient full name data textField
        CustomJTextField patientNameTextField = new CustomJTextField(treatment.getPatient().getFirstName() + " " + treatment.getPatient().getLastName() + " " + treatment.getPatient().getPatientBloodType(), false);
        patientNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        // Add patient full name data to JPanel
        add(patientNameTextField);
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());


        // Second Row
        // Add treatment start description to JPanel
        add(new CustomJLabel("Treatment Start:", SwingConstants.CENTER));

        // Treatment start data textField
        CustomJTextField treatmentStartTextField = new CustomJTextField(treatment.getTreatmentStart().toString(), false);
        // Add treatment start data to JPanel
        add(treatmentStartTextField);

        // Add treatment end description to JPanel
        add(new CustomJLabel("Treatment End:", SwingConstants.CENTER));

        // Treatment end data textField
        treatmentEndTextField = new CustomJTextField("", false);
        // Add treatment end data to JPanel
        add(treatmentEndTextField);

        // Third Row
        // Add patient diseases description to JPanel
        add(new CustomJLabel("Diseases:", SwingConstants.CENTER));

        // Patient diseases data textField
        String disease = "";
        if (treatment.getDisease() != null) {
            disease = treatment.getDisease();
        }
        diseasesTextField = new CustomJTextField(disease);
        // Add patient diseases data to JPanel
        add(diseasesTextField);

        // Add allergies description to JPanel
        add(new CustomJLabel("Allergies:", SwingConstants.CENTER));

        // Allergies data textField
        CustomJTextField allergiesTextField = new CustomJTextField(treatment.getPatient().getPatientAllergies(), false);
        // Add allergies data to JPanel
        add(allergiesTextField);



        // Fourth Row
        // Add prescribed drugs to JPanel
        add(new CustomJLabel("Prescribed drugs:", SwingConstants.CENTER));

        // Prescribed drugs data text field
        String drugs = treatment.getPrescribedMedicine().size() > 0 ? String.join(", ", treatment.getPrescribedMedicine()) : "";
        prescribedDrugsTextField = new CustomJTextField(drugs);
        // Add prescribed drugs data to JPanel
        add(prescribedDrugsTextField);

        // Add patient health after treatment description to JPanel
        add(new CustomJLabel("Patient health after treatment:", SwingConstants.CENTER));

        // Patient health after treatment data text field
        String pTreatment = treatment.getAfterTreatmentHealthState() == null ? "" : treatment.getAfterTreatmentHealthState();
        patientHealthAfterTreatmentDataTextField = new CustomJTextField(pTreatment);
        // Add patient health after treatment data to JPanel
        add(patientHealthAfterTreatmentDataTextField);



        // Fifth row
        // Assigned bed data text field
        String id = "";
        boolean operationNeeded = false;
        if (treatment.getPatient().getPatientBed() != null) {
            id = String.valueOf(treatment.getPatient().getPatientBed().getId());
            operationNeeded = true;
        }
        CustomJTextField assignedBedTextField = new CustomJTextField(id, false);
        // is operation needed button
        JRadioButton isOperationNeededButton = new IsOperationNeededRadioButton("", treatment, assignedBedTextField);
        isOperationNeededButton.setSelected(operationNeeded);
        add(isOperationNeededButton);

        // Add assigned bed button description to JPanel
        add(new CustomJLabel("    Operation needed"));

        // Add assigned bed description to JPanel
        add(new CustomJLabel("Assigned bed:", SwingConstants.CENTER));

        // Add assigned bed data to JPanel
        add(assignedBedTextField);

        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
    }

    public JTextField getDiseasesTextField() {
        return diseasesTextField;
    }

    public JTextField getPrescribedDrugsTextField() {
        return prescribedDrugsTextField;
    }

    public JTextField getPatientHealthAfterTreatmentDataTextField() {
        return patientHealthAfterTreatmentDataTextField;
    }

    public void setTreatmentEndTextField(String message) {
        treatmentEndTextField.setText(message);
    }
}
