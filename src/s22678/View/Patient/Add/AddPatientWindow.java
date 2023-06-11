package s22678.View.Patient.Add;

import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

public class AddPatientWindow extends JFrame {
    private static JTextField PESEL;
    private static JTextField firstName;
    private static JTextField lastName;
    private static JTextField address;
    private static JTextField bloodType;
    public AddPatientWindow() {
        setTitle("Add Patient");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);

        PESEL = new JTextField();
        firstName = new JTextField();
        lastName = new JTextField();
        address = new JTextField();
        bloodType = new JTextField();

        add(PESEL);
        add(firstName);
        add(lastName);
        add(address);
        add(bloodType);

//        final Person patient1 = new Person(43343, "Kornel", "Sikora", "Klonowa 7", "A+", patientCard1);

        setVisible(true);
    }
}
