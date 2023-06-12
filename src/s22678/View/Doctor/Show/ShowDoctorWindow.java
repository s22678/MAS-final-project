package s22678.View.Doctor.Show;

import s22678.Model.DoctorField;
import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class ShowDoctorWindow extends JFrame {
    public ShowDoctorWindow(String pesel, String firstName, String lastName) {
        setTitle("Show Details for: dr " + firstName + " " + lastName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        Person doctor = Person.getPersonByFullNameandPesel(pesel, firstName, lastName);

        JPanel textPanel = new JPanel(new GridLayout(1, 4));
        JPanel treatmentPanel = new JPanel();

        GridLayout masterGridLayout = new GridLayout(8 ,1);
        masterGridLayout.setVgap(40);

        // First column label description
        JPanel firstDescriptionLabelColumn = new JPanel(masterGridLayout);

        // Second column label description
        JPanel secondDescriptionLabelColumn = new JPanel(masterGridLayout);

        // First column label data
        JPanel firstDataLabelColumn = new JPanel(masterGridLayout);

        // Second column label data
        JPanel secondDataLabelColumn = new JPanel(masterGridLayout);

        // firstName label description
        JLabel firstNameDescriptionLabel = new JLabel("Name:");
        firstNameDescriptionLabel.setFont(serifFont);

        // add firstName label description to JPanel
        firstDescriptionLabelColumn.add(firstNameDescriptionLabel);

        // firstName label data
        JLabel firstNameDataLabel = new JLabel(firstName);
        firstNameDataLabel.setFont(serifFont);

        // add firstName label data to JPanel
        firstDataLabelColumn.add(firstNameDataLabel);

        // lastName label description
        JLabel lastNameDescriptionLabel = new JLabel("Last Name:");
        lastNameDescriptionLabel.setFont(serifFont);

        // add lastName label description to JPanel
        secondDescriptionLabelColumn.add(lastNameDescriptionLabel);

        // lastName label data
        JLabel lastNameDataLabel = new JLabel(lastName);
        lastNameDataLabel.setFont(serifFont);

        // add lastName label data to JPanel
        secondDataLabelColumn.add(lastNameDataLabel);

        // pesel label description
        JLabel peselDescriptionLabel = new JLabel("PESEL:");
        peselDescriptionLabel.setFont(serifFont);

        // add pesel label description to JPanel
        firstDescriptionLabelColumn.add(peselDescriptionLabel);

        // pesel label data
        JLabel peselDataLabel = new JLabel(pesel);
        peselDataLabel.setFont(serifFont);

        // add pesel label data to JPanel
        firstDataLabelColumn.add(peselDataLabel);

        // specialization label description
        JLabel specializationDescriptionLabel = new JLabel("Specialization:");
        specializationDescriptionLabel.setFont(serifFont);

        // add specialization label description to JPanel
        secondDescriptionLabelColumn.add(specializationDescriptionLabel);

        // specialization label data
        JLabel specializationDataLabel = new JLabel(doctor.getDoctorSpecialization());
        specializationDataLabel.setFont(serifFont);

        // add specialization label data to JPanel
        secondDataLabelColumn.add(specializationDataLabel);

        // salary label description
        JLabel salaryDescriptionLabel = new JLabel("Salary:");
        salaryDescriptionLabel.setFont(serifFont);

        // add salary label description to JPanel
        firstDescriptionLabelColumn.add(salaryDescriptionLabel);

        // salary label data
        JLabel salaryDataLabel = new JLabel(String.valueOf(doctor.getDoctorSalary()));
        salaryDataLabel.setFont(serifFont);

        // add salary label data to JPanel
        firstDataLabelColumn.add(salaryDataLabel);

        // fields label description
        JLabel fieldsDescriptionLabel = new JLabel("Fields:");
        fieldsDescriptionLabel.setFont(serifFont);

        // add fields label description to JPanel
        secondDescriptionLabelColumn.add(fieldsDescriptionLabel);

        // fields label data
        String tmp = "";
        for (DoctorField field : doctor.getDoctorFields()) {
            tmp = tmp + " " + field.toString();
        }
        JLabel fieldsDataLabel = new JLabel(tmp);
        fieldsDataLabel.setFont(serifFont);

        // add fields label data to JPanel
        secondDataLabelColumn.add(fieldsDataLabel);

        textPanel.add(firstDescriptionLabelColumn);
        textPanel.add(firstDataLabelColumn);
        textPanel.add(secondDescriptionLabelColumn);
        textPanel.add(secondDataLabelColumn);

        add(textPanel);
        setVisible(true);
    }
}

//    private java.util.List<Treatment> treatments = new ArrayList<>();
//    private java.util.List<String> trainings = new ArrayList<>();
//    private List<String> successfulOperations = new ArrayList<>();
