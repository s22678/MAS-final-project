package s22678.View.Treatment.SelectDoctor;

import s22678.View.Main.MainView;

import javax.swing.*;

public class ListDoctorWithPatientCloseButton extends JButton {
    public ListDoctorWithPatientCloseButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            System.out.println("changing view to defaultPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
