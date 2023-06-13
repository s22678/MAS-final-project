package s22678.View.CustomSwingClasses;

import javax.swing.*;

import java.awt.*;

import static s22678.View.Main.MainView.serifFont;
import static s22678.View.Main.MainView.textFieldHeight;
import static s22678.View.Main.MainView.textFieldWidth;

public class CustomJTextField extends JTextField {

    public CustomJTextField() {
        setFont(serifFont);
        setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
    }

    public CustomJTextField(String text) {
        super(text);
        setFont(serifFont);
        setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
    }
}
