package s22678.View.CustomSwingClasses;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class CustomJLabel extends JLabel {
    public CustomJLabel() {
        setFont(serifFont);
    }

    public CustomJLabel(String text) {
        super(text);
        setFont(serifFont);
    }

    public CustomJLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setFont(serifFont);
    }
}
