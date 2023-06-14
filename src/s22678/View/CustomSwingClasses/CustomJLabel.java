package s22678.View.CustomSwingClasses;

import javax.swing.*;

import static s22678.View.Main.MainView.getSerifFont;

public class CustomJLabel extends JLabel {
    public CustomJLabel() {
        setFont(getSerifFont());
    }

    public CustomJLabel(String text) {
        super(text);
        setFont(getSerifFont());
    }

    public CustomJLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setFont(getSerifFont());
    }
}
