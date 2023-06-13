package s22678.View.Doctor.List;

import s22678.View.CustomSwingClasses.CustomJButton;

public class ListDoctorRefreshButton extends CustomJButton {
    public ListDoctorRefreshButton(String text) {
        super(text);

        addActionListener(e -> {
            ListDoctorActionListener.reload();
        });
    }
}
