package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ShowTreatmentTextPanel extends JPanel {
    public ShowTreatmentTextPanel(Treatment treatment) {
        GridLayout gridLayout = new GridLayout(1 ,4);
        gridLayout.setVgap(40);
        setLayout(gridLayout);

        GridLayout textLayout = new GridLayout(5 ,1);
        textLayout.setVgap(40);

        // First column label description
        JPanel firstDescriptionLabelColumn = new JPanel(textLayout);

        // Second column label description
        JPanel secondDescriptionLabelColumn = new JPanel(textLayout);

        // First column label data
        JPanel firstDataLabelColumn = new JPanel(textLayout);

        // Second column label data
        JPanel secondDataLabelColumn = new JPanel(textLayout);

        // First Row
        // Doctor full name description label
        JLabel doctorNameLabel = new JLabel("Doctor: ");
        doctorNameLabel.setFont(serifFont);
        // Add doctor full name to JPanel
        firstDescriptionLabelColumn.add(doctorNameLabel);

        // Doctor full name data textField
        JTextField doctorNameTextField = new JTextField(treatment.getDoctor().getFirstName() + " " + treatment.getDoctor().getLastName());
        doctorNameTextField.setFont(serifFont);
        doctorNameTextField.setEnabled(false);
        // Add doctor full name data to JPanel
        firstDataLabelColumn.add(doctorNameTextField);

        // Patient Full Name description label
        JLabel patientNameLabel = new JLabel("Patient: ");
        patientNameLabel.setFont(serifFont);
        // Add patient full name to JPanel
        secondDescriptionLabelColumn.add(patientNameLabel);

        // Patient full name data textField
        JTextField patientNameTextField = new JTextField(treatment.getPatient().getFirstName() + " " + treatment.getPatient().getLastName());
        patientNameTextField.setFont(serifFont);
        patientNameTextField.setEnabled(false);
        // Add patient full name data to JPanel
        secondDataLabelColumn.add(patientNameTextField);



        // Second Row
        // Treatment start description label
        JLabel treatmentStartLabel = new JLabel("Treatment Start: ");
        treatmentStartLabel.setFont(serifFont);
        // Add treatment start description to JPanel
        firstDescriptionLabelColumn.add(treatmentStartLabel);

        // Treatment start data textField
        JTextField treatmentStartTextField = new JTextField(treatment.getTreatmentStart().toString());
        treatmentStartTextField.setFont(serifFont);
        treatmentStartTextField.setEnabled(false);
        // Add treatment start data to JPanel
        firstDataLabelColumn.add(treatmentStartTextField);

        // Treatment end description label
        JLabel treatmentEndLabel = new JLabel("Treatment End: ");
        treatmentEndLabel.setFont(serifFont);
        // Add treatment end description to JPanel
        secondDescriptionLabelColumn.add(treatmentEndLabel);

        // Treatment end data textField
        JTextField treatmentEndTextField = new JTextField();
        treatmentEndTextField.setFont(serifFont);
        treatmentEndTextField.setEnabled(false);
        // Add treatment end data to JPanel
        secondDataLabelColumn.add(treatmentEndTextField);



        // Third Row
        // Patient diseases description label
        JLabel diseasesLabel = new JLabel("Diseases: ");
        diseasesLabel.setFont(serifFont);
        // Add patient diseases description to JPanel
        firstDescriptionLabelColumn.add(diseasesLabel);

        // Patient diseases data textField
        JTextField diseasesTextField = new JTextField();
        diseasesTextField.setFont(serifFont);
        diseasesTextField.setEnabled(false);
        // Add patient diseases data to JPanel
        firstDataLabelColumn.add(diseasesTextField);

        // Allergies description label
        JLabel allergiesLabel = new JLabel("Allergies: ");
        allergiesLabel.setFont(serifFont);
        // Add allergies description to JPanel
        secondDescriptionLabelColumn.add(allergiesLabel);

        // Allergies data textField
        JTextField allergiesTextField = new JTextField(treatment.getPatient().getAllergies());
        allergiesTextField.setFont(serifFont);
        allergiesTextField.setEnabled(false);
        // Add allergies data to JPanel
        secondDataLabelColumn.add(allergiesTextField);
    }
}
