package s22678.View.Doctor.List;

import s22678.View.Main.MainView;

import javax.swing.*;

public class ListDoctorCloseButton extends JButton {
    public ListDoctorCloseButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            System.out.println("changing view to defaultPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
