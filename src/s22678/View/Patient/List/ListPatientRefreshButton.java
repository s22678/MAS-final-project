package s22678.View.Patient.List;

import s22678.View.CustomSwingClasses.CustomJButton;

import javax.swing.*;

public class ListPatientRefreshButton extends CustomJButton {
    public ListPatientRefreshButton(String text) {
        super(text);

        addActionListener(e -> {
            ListPatientActionListener.reload();
        });
    }
}
