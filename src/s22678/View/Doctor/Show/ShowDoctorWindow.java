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
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Person doctor = Person.getPersonByFullNameandPesel(pesel, firstName, lastName);

        JLabel firstNameLabel = new JLabel("Name: " + firstName);
        firstNameLabel.setFont(serifFont);
        JLabel lastNameLabel = new JLabel("Last Name: " + lastName);
        lastNameLabel.setFont(serifFont);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNameLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(lastNameLabel);






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