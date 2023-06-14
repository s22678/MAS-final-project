package s22678.View.Doctor.Add;

import s22678.Controller.PersonController;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;
import java.awt.*;

public class AddDoctorButtonPanel extends JPanel {
    public AddDoctorButtonPanel() {
        GridLayout gridLayout = new GridLayout();
        gridLayout.setHgap(30);
        setLayout(gridLayout);

        add(new AddDoctorButton());
    }
}
