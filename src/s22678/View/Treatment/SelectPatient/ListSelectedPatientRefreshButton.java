package s22678.View.Treatment.SelectPatient;

import s22678.Model.Person;
import s22678.View.CustomSwingClasses.CustomJButton;

import javax.swing.*;

public class ListSelectedPatientRefreshButton extends CustomJButton {
    public ListSelectedPatientRefreshButton(String text, ListSelectedPatientPanel panel) {
        super(text);

        addActionListener(e -> {
            ListSelectedPatientActionListener.reload(panel.getDoctor());
        });
    }
}
