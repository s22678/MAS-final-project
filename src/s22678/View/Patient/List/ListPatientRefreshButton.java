package s22678.View.Patient.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;

public class ListPatientRefreshButton extends JButton {
    public ListPatientRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListPatientActionListener.action();
        });
    }
}
