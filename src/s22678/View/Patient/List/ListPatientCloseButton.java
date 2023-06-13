package s22678.View.Patient.List;

import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.Main.MainView;

import javax.swing.*;

public class ListPatientCloseButton extends CustomJButton {
    public ListPatientCloseButton(String buttonName) {
        super(buttonName);

        addActionListener(e -> {
            System.out.println("changing view defaultPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
