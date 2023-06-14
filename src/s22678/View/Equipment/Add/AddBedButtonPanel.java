package s22678.View.Equipment.Add;

import javax.swing.*;
import java.awt.*;

public class AddBedButtonPanel extends JPanel {
    public AddBedButtonPanel() {
        GridLayout layout = new GridLayout();
        layout.setHgap(30);
        setLayout(layout);

        add(new AddBedButton());
    }
}
