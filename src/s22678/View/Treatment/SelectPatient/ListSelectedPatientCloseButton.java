package s22678.View.Treatment.SelectPatient;

import s22678.View.Main.MainView;

import javax.swing.*;

public class ListSelectedPatientCloseButton extends JButton {
    public ListSelectedPatientCloseButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            System.out.println("changing view to listDoctorWithPatientPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listDoctorWithPatientPanel");
        });
    }
}
