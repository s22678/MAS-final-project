package s22678.View.Doctor.Show;

import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class ShowDoctorWindow extends JFrame {
    public ShowDoctorWindow(String pesel, String firstName, String lastName) {
        setTitle("Show Details for: dr " + firstName + " " + lastName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 4));

        Person doctor = Person.getPersonByFullNameandPesel(pesel, firstName, lastName);

        GridLayout masterLayout = new GridLayout(8 ,1);
        masterLayout.setVgap(40);

        // First column label description
        JPanel firstDescriptionLabelColumn = new JPanel(masterLayout);

        // Second column label description
        JPanel secondDescriptionLabelColumn = new JPanel(masterLayout);

        // First column label data
        JPanel firstDataLabelColumn = new JPanel(masterLayout);

        // Second column label data
        JPanel secondDataLabelColumn = new JPanel(masterLayout);

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

        add(firstDescriptionLabelColumn);
        add(firstDataLabelColumn);
        add(secondDescriptionLabelColumn);
        add(secondDataLabelColumn);






//        JLabel nameLabel = new JLabel("Name: " + pesel);
//        JLabel ageLabel = new JLabel("Age: " + firstName);
//        JLabel emailLabel = new JLabel("Email: " + lastName);

//        add(nameLabel);
//        add(ageLabel);
//        add(emailLabel);


        setVisible(true);
    }
}



//    private int salary;
//    private String specialization;
//    private EnumSet<DoctorField> fields;
//    private java.util.List<Treatment> treatments = new ArrayList<>();
//    private java.util.List<String> trainings = new ArrayList<>();
//    private List<String> successfulOperations = new ArrayList<>();
//    private String firstName;
//    private String lastName;
//    private String PESEL;