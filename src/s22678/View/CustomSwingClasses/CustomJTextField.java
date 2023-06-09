package s22678.View.CustomSwingClasses;

import javax.swing.*;

import java.awt.*;

import static s22678.View.Main.MainView.*;

public class CustomJTextField extends JTextField {

    public CustomJTextField() {
        setFont(getSerifFont());
        setPreferredSize(new Dimension(getTextFieldWidth(), getTextFieldHeight()));
    }

    public CustomJTextField(String text) {
        super(text);
        setFont(getSerifFont());
        setPreferredSize(new Dimension(getTextFieldWidth(), getTextFieldHeight()));
    }

    public CustomJTextField(String text, boolean enabled) {
        super(text);
        setEnabled(enabled);
        setDisabledTextColor(Color.black);
        setFont(getSerifFont());
        setPreferredSize(new Dimension(getTextFieldWidth(), getTextFieldHeight()));
    }

    public CustomJTextField(String text, java.awt.Dimension preferredSize) {
        super(text);
        setFont(getSerifFont());
        setPreferredSize(preferredSize);
    }
}
