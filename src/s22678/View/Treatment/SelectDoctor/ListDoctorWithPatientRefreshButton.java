package s22678.View.Treatment.SelectDoctor;

import javax.swing.*;

public class ListDoctorWithPatientRefreshButton extends JButton {
    public ListDoctorWithPatientRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListDoctorWithPatientActionListener.reload();
        });
    }
}
