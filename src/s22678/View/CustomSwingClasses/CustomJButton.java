package s22678.View.CustomSwingClasses;

import javax.swing.*;

import static s22678.View.Main.MainView.getSerifFont;

public class CustomJButton extends JButton {
    public CustomJButton() {
        setFont(getSerifFont());
    }

    public CustomJButton(String text) {
        super(text);
        setFont(getSerifFont());
    }
}
