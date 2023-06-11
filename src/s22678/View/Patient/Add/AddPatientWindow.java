package s22678.View.Patient.Add;

import s22678.Model.PatientCard;
import s22678.Model.Person;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class AddPatientWindow extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;
    private static JTextField PESELTextField;
    private static JTextField firstNameTextField;
    private static JTextField lastNameTextField;
    private static JTextField addressTextField;
    private static JTextField bloodTypeTextField;
    private static JFrame frame;

    public AddPatientWindow() {
        setTitle("Add Patient");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(5 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);

        GridLayout textFieldLayout = new GridLayout(5 ,1);
        textFieldLayout.setVgap(40);
        JPanel textFieldContainer = new JPanel(textFieldLayout);

        PESELTextField = new JTextField();
        PESELTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        PESELTextField.setFont(serifFont);

        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        firstNameTextField.setFont(serifFont);

        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        lastNameTextField.setFont(serifFont);

        addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        addressTextField.setFont(serifFont);

        bloodTypeTextField = new JTextField();
        bloodTypeTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        bloodTypeTextField.setFont(serifFont);

        JLabel PESELLabel = new JLabel("PESEL", SwingConstants.CENTER);
        PESELLabel.setFont(serifFont);

        JLabel firstNameLabel = new JLabel("First Name", SwingConstants.CENTER);
        firstNameLabel.setFont(serifFont);

        JLabel lastNameLabel = new JLabel("Last Name", SwingConstants.CENTER);
        lastNameLabel.setFont(serifFont);

        JLabel addressLabel = new JLabel("Address", SwingConstants.CENTER);
        addressLabel.setFont(serifFont);

        JLabel bloodTypeLabel = new JLabel("Blood Type", SwingConstants.CENTER);
        bloodTypeLabel.setFont(serifFont);

        labelContainer.add(PESELLabel);
        labelContainer.add(firstNameLabel);
        labelContainer.add(lastNameLabel);
        labelContainer.add(addressLabel);
        labelContainer.add(bloodTypeLabel);

        textFieldContainer.add(PESELTextField);
        textFieldContainer.add(firstNameTextField);
        textFieldContainer.add(lastNameTextField);
        textFieldContainer.add(addressTextField);
        textFieldContainer.add(bloodTypeTextField);

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            new Person(Integer.parseInt(PESELTextField.getText()), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), bloodTypeTextField.getText(), new PatientCard());
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
        });

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        masterPanel.add(labelContainer);
        masterPanel.add(textFieldContainer);

        add(masterPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JTextField getPESELTextField() {
        return PESELTextField;
    }

    public static JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public static JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public static JTextField getAddressTextField() {
        return addressTextField;
    }

    public static JTextField getBloodTypeTextField() {
        return bloodTypeTextField;
    }
}
