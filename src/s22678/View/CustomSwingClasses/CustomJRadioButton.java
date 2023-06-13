package s22678.View.CustomSwingClasses;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class CustomJRadioButton extends JRadioButton {
    public CustomJRadioButton(String text, int alignment) {
        super(text);
        setFont(serifFont);
        setSize(70, 70);
        setHorizontalAlignment(alignment);
    }
}
