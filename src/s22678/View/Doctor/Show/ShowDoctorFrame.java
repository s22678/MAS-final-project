package s22678.View.Doctor.Show;

import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class ShowDoctorFrame extends JFrame {
    public ShowDoctorFrame(String pesel, String firstName, String lastName) {
        setTitle("Show Details for: dr " + firstName + " " + lastName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 1));

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

        // add firstName label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("Name:"));

        // add firstName label data to JPanel
        firstDataLabelColumn.add(new CustomJLabel(firstName));

        // add lastName label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Last Name:"));

        // add lastName label data to JPanel
        secondDataLabelColumn.add(new CustomJLabel(lastName));

        // add pesel label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("PESEL:"));

        // add pesel label data to JPanel
        firstDataLabelColumn.add(new CustomJLabel(pesel));

        // add specialization label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Specialization:"));

        // add specialization label data to JPanel
        secondDataLabelColumn.add(new CustomJLabel(doctor.getDoctorSpecialization()));

        // add salary label description to JPanel
        firstDescriptionLabelColumn.add(new CustomJLabel("Salary:"));

        // add salary label data to JPanel
        firstDataLabelColumn.add(new CustomJLabel(String.valueOf(doctor.getDoctorSalary())));

        // add fields label description to JPanel
        secondDescriptionLabelColumn.add(new CustomJLabel("Fields:"));

        // fields label data
        String tmp = "";
        for (DoctorField field : doctor.getDoctorFields()) {
            tmp = tmp + " " + field.toString();
        }
        // add fields label data to JPanel
        secondDataLabelColumn.add(new CustomJLabel(tmp));

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
