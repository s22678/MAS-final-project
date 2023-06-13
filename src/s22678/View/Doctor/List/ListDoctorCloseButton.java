package s22678.View.Doctor.List;

import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.Main.MainView;

public class ListDoctorCloseButton extends CustomJButton {
    public ListDoctorCloseButton(String text) {
        super(text);

        addActionListener(e -> {
            System.out.println("changing view to defaultPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "defaultPanel");
        });
    }
}
