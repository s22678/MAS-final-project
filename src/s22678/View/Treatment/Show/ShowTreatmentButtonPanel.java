package s22678.View.Treatment.Show;

import javax.swing.*;
import java.awt.*;

public class ShowTreatmentButtonPanel extends JPanel {
    public ShowTreatmentButtonPanel() {
        GridLayout gridLayout = new GridLayout(1 ,3);
        gridLayout.setHgap(40);
        setLayout(gridLayout);
        setPreferredSize(new Dimension(50, 75));

        add(new SaveTreatmentButton("Save"));
        add(new EndTreatmentButton("End Treatment"));
    }
}