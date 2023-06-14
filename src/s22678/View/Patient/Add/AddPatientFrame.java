package s22678.View.Patient.Add;

import s22678.Controller.PersonController;
import s22678.Model.PatientCard;
import s22678.Model.Person;
import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJRadioButton;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;
import static s22678.View.Main.MainView.*;

public class AddPatientFrame extends JFrame {

    public AddPatientFrame() {
        setTitle("Add Patient");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        add(new AddPatientTextPanel(), BorderLayout.CENTER);
        add(new AddPatientButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
}
