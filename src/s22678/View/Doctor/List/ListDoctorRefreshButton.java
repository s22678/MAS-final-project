package s22678.View.Doctor.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;

public class ListDoctorRefreshButton extends JButton {
    public ListDoctorRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListDoctorActionListener.action();
        });
    }
}
