package s22678.View;

import s22678.Model.Person;

import javax.swing.*;

public class PersonView {
    private JFrame frame;
    private JTextField nameField;
    private JTextField peselField;
    private JTextField idDoctorField;
    private JTextField bloodTypeField;
    private JButton addDoctorButton;
    private JButton addPatientButton;

    public PersonView() {
        frame = new JFrame("Add Person");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel peselLabel = new JLabel("PESEL:");
        peselLabel.setBounds(10, 50, 80, 25);
        panel.add(peselLabel);

        peselField = new JTextField();
        peselField.setBounds(100, 50, 165, 25);
        panel.add(peselField);

        JLabel idDoctorLabel = new JLabel("Doctor ID:");
        idDoctorLabel.setBounds(10, 80, 80, 25);
        panel.add(idDoctorLabel);

        idDoctorField = new JTextField();
        idDoctorField.setBounds(100, 80, 165, 25);
        panel.add(idDoctorField);

        JLabel bloodTypeLabel = new JLabel("Blood Type:");
        bloodTypeLabel.setBounds(10, 110, 80, 25);
        panel.add(bloodTypeLabel);

        bloodTypeField = new JTextField();
        bloodTypeField.setBounds(100, 110, 165, 25);
        panel.add(bloodTypeField);

        addDoctorButton = new JButton("Add Doctor");
        addDoctorButton.setBounds(30, 150, 120, 25);
        addDoctorButton.addActionListener(e -> {
            String name = getName();
            int pesel = getPESEL();
            int idDoctor = getDoctorId();

            // Add doctor logic here
            Person person = new Person(pesel, name, idDoctor);
            System.out.println("Added Doctor: " + person);
            clearFields();
        });
        panel.add(addDoctorButton);

        addPatientButton = new JButton("Add Patient");
        addPatientButton.setBounds(160, 150, 120, 25);
        addPatientButton.addActionListener(e -> {
            String name = getName();
            int pesel = getPESEL();
            String bloodType = getBloodType();

            // Add patient logic here
            Person person = new Person(pesel, name, bloodType);
            System.out.println("Added Patient: " + person);
            clearFields();
        });
        panel.add(addPatientButton);

        frame.setVisible(true);
    }

    public String getName() {
        return nameField.getText();
    }

    public int getPESEL() {
        return Integer.parseInt(peselField.getText());
    }

    public int getDoctorId() {
        return Integer.parseInt(idDoctorField.getText());
    }

    public String getBloodType() {
        return bloodTypeField.getText();
    }

    public void clearFields() {
        nameField.setText("");
        peselField.setText("");
        idDoctorField.setText("");
        bloodTypeField.setText("");
    }

//    public void addAddDoctorButtonListener(ActionListener listener) {
//        addDoctorButton.addActionListener(listener);
//    }
//
//    public void addAddPatientButtonListener(ActionListener listener) {
//        addPatientButton.addActionListener(listener);
//    }
}
