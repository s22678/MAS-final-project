package s22678.View.Treatment.SelectDoctor;

import s22678.View.CustomSwingClasses.CustomJButton;

public class ListDoctorWithPatientRefreshButton extends CustomJButton {
    public ListDoctorWithPatientRefreshButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            ListDoctorWithPatientActionListener.reload();
        });
    }
}
