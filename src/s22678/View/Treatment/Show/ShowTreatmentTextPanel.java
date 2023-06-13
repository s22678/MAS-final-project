package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ShowTreatmentTextPanel extends JPanel {
    public ShowTreatmentTextPanel(Treatment treatment) {

        GridLayout mainLayout = new GridLayout(7 ,4);
        mainLayout.setVgap(40);
        setLayout(mainLayout);


        // First Row
        // Doctor full name description label
        JLabel doctorNameLabel = new JLabel("Doctor:", SwingConstants.CENTER);
        doctorNameLabel.setFont(serifFont);
        // Add doctor full name to JPanel
        add(doctorNameLabel);

        // Doctor full name data textField
        JTextField doctorNameTextField = new JTextField(treatment.getDoctor().getFirstName() + " " + treatment.getDoctor().getLastName());
        doctorNameTextField.setFont(serifFont);
        doctorNameTextField.setEnabled(false);
        doctorNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        // Add doctor full name data to JPanel
        add(doctorNameTextField);

        // Patient Full Name description label
        JLabel patientNameLabel = new JLabel("Patient:", SwingConstants.CENTER);
        patientNameLabel.setFont(serifFont);
        // Add patient full name to JPanel
        add(patientNameLabel);

        // Patient full name data textField
        JTextField patientNameTextField = new JTextField(treatment.getPatient().getFirstName() + " " + treatment.getPatient().getLastName());
        patientNameTextField.setFont(serifFont);
        patientNameTextField.setEnabled(false);
        patientNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        // Add patient full name data to JPanel
        add(patientNameTextField);
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());


        // Second Row
        // Treatment start description label
        JLabel treatmentStartLabel = new JLabel("Treatment Start:", SwingConstants.CENTER);
        treatmentStartLabel.setFont(serifFont);
        // Add treatment start description to JPanel
        add(treatmentStartLabel);

        // Treatment start data textField
        JTextField treatmentStartTextField = new JTextField(treatment.getTreatmentStart().toString());
        treatmentStartTextField.setFont(serifFont);
        treatmentStartTextField.setEnabled(false);
        // Add treatment start data to JPanel
        add(treatmentStartTextField);

        // Treatment end description label
        JLabel treatmentEndLabel = new JLabel("Treatment End:", SwingConstants.CENTER);
        treatmentEndLabel.setFont(serifFont);
        // Add treatment end description to JPanel
        add(treatmentEndLabel);

        // Treatment end data textField
        JTextField treatmentEndTextField = new JTextField();
        treatmentEndTextField.setFont(serifFont);
        treatmentEndTextField.setEnabled(false);
        // Add treatment end data to JPanel
        add(treatmentEndTextField);



        // Third Row
        // Patient diseases description label
        JLabel diseasesLabel = new JLabel("Diseases:", SwingConstants.CENTER);
        diseasesLabel.setFont(serifFont);
        // Add patient diseases description to JPanel
        add(diseasesLabel);

        // Patient diseases data textField
        JTextField diseasesTextField = new JTextField();
        diseasesTextField.setFont(serifFont);
        diseasesTextField.setEnabled(true);
        // Add patient diseases data to JPanel
        add(diseasesTextField);

        // Allergies description label
        JLabel allergiesLabel = new JLabel("Allergies:", SwingConstants.CENTER);
        allergiesLabel.setFont(serifFont);
        // Add allergies description to JPanel
        add(allergiesLabel);

        // Allergies data textField
        JTextField allergiesTextField = new JTextField(treatment.getPatient().getAllergies());
        allergiesTextField.setFont(serifFont);
        allergiesTextField.setEnabled(false);
        // Add allergies data to JPanel
        add(allergiesTextField);



        // Fourth Row
        // Prescribed drugs description label
        JLabel prescribedDrugsLabel = new JLabel("Prescribed drugs:", SwingConstants.CENTER);
        prescribedDrugsLabel.setFont(serifFont);
        // Add prescribed drugs to JPanel
        add(prescribedDrugsLabel);

        // Prescribed drugs data text field
        String drugs = treatment.getPrescribedMedicine().size() > 0 ? String.join(", ", treatment.getPrescribedMedicine()) : "";
        JTextField prescribedDrugsTextField = new JTextField(drugs);
        prescribedDrugsTextField.setFont(serifFont);
        // Add prescribed drugs data to JPanel
        add(prescribedDrugsTextField);

        // Patient health after treatment description label
        JLabel patientHealtAfterTreatmentLabel = new JLabel("Patient health after treatment:", SwingConstants.CENTER);
        patientHealtAfterTreatmentLabel.setFont(serifFont);
        // Add patient health after treatment description to JPanel
        add(patientHealtAfterTreatmentLabel);

        // Patient health after treatment data text field
        String pTreatment = treatment.getAfterTreatmentHealtState() == null ? "" : treatment.getAfterTreatmentHealtState();
        JTextField patientHealthAfterTreatmentDataTextField = new JTextField(pTreatment);
        patientHealthAfterTreatmentDataTextField.setFont(serifFont);
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
        JTextField assignedBedTextField = new JTextField(id);
        // is operation needed button
        JRadioButton isOperationNeededButton = new IsOperationNeededRadioButton("", treatment, assignedBedTextField);
        isOperationNeededButton.setSelected(operationNeeded);
        add(isOperationNeededButton);
        JLabel buttonDescription = new JLabel("    Operation needed");
        buttonDescription.setFont(serifFont);
        add(buttonDescription);

        // Assigned bed description label
        JLabel assignedBedLabel = new JLabel("Assigned bed:", SwingConstants.CENTER);
        assignedBedLabel.setFont(serifFont);
        // Add assigned bed description to JPanel
        add(assignedBedLabel);

        // Assigned bed data text field
        assignedBedTextField.setFont(serifFont);
        assignedBedTextField.setEnabled(false);
        // Add assigned bed data to JPanel
        add(assignedBedTextField);

        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());
    }
}
