package s22678.View.Equipment.Add;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class AddBedFrame extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;

    public AddBedFrame() {
        setTitle("Add Bed");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(getScreenWidth(), getScreenHeight());
        setLocationRelativeTo(null);

        add(new AddBedTextPanel(), BorderLayout.CENTER);
        add(new AddBedButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
}
