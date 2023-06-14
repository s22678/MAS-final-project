package s22678.View.Equipment.Add;

import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;
import java.awt.*;

public class AddBedTextPanel extends JPanel {
    private static AddBedTextPanel thisObj;
    private CustomJTextField roomTextField;
    public AddBedTextPanel() {
        setLayout(new GridLayout(3 ,2));

        GridLayout layout = new GridLayout(1 ,1);
        layout.setVgap(40);

        JPanel labelContainer = new JPanel(layout);
        JPanel textFieldContainer = new JPanel(layout);

        roomTextField = new CustomJTextField();
        textFieldContainer.add(roomTextField);

        JLabel roomLabel = new CustomJLabel("Select room for the bed", SwingConstants.CENTER);
        labelContainer.add(roomLabel);

        // Empty placeholder
        add(new JLabel());
        add(new JLabel());

        add(labelContainer);
        add(textFieldContainer);

        // Empty placeholder
        add(new JLabel());
        add(new JLabel());

        thisObj = this;
    }

    public static AddBedTextPanel getAddBedTextPanel() {
        return thisObj;
    }

    public CustomJTextField getRoomTextField() {
        return roomTextField;
    }
}
