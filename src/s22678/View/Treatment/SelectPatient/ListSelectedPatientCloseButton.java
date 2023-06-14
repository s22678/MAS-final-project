package s22678.View.Treatment.SelectPatient;

import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.Main.MainView;

public class ListSelectedPatientCloseButton extends CustomJButton {
    public ListSelectedPatientCloseButton(String text) {
        super(text);

        addActionListener(e -> {
            System.out.println("changing view to listDoctorWithPatientPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listDoctorWithPatientPanel");
        });
    }
}
