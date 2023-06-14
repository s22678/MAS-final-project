package s22678.View.Doctor.Add;

import s22678.Controller.PersonController;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class AddDoctorFrame extends JFrame {


    public AddDoctorFrame() {
        setTitle("Add Doctor");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        add(new AddDoctorTextPanel(), BorderLayout.CENTER);
        add(new AddDoctorButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
}
