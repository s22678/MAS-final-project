package s22678.View.CustomSwingClasses;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class CustomJButton extends JButton {
    public CustomJButton() {
        setFont(serifFont);
    }

    public CustomJButton(String text) {
        super(text);
        setFont(serifFont);
    }
}
