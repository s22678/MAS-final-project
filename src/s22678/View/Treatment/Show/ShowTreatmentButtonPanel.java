package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;
import java.awt.*;

public class ShowTreatmentButtonPanel extends JPanel {
    public ShowTreatmentButtonPanel(Treatment treatment, ShowTreatmentTextPanel panel) {
        GridLayout gridLayout = new GridLayout(1 ,3);
        gridLayout.setHgap(40);
        setLayout(gridLayout);
        setPreferredSize(new Dimension(50, 75));

        add(new SaveTreatmentButton("Save", treatment, panel));
        add(new EndTreatmentButton("End Treatment", treatment, panel));
    }
}
