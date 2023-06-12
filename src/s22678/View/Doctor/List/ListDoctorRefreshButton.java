package s22678.View.Doctor.List;

import javax.swing.*;

public class ListDoctorRefreshButton extends JButton {
    public ListDoctorRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListDoctorActionListener.reload();
        });
    }
}
