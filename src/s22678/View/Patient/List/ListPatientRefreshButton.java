package s22678.View.Patient.List;

import javax.swing.*;

public class ListPatientRefreshButton extends JButton {
    public ListPatientRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListPatientActionListener.reload();
        });
    }
}
