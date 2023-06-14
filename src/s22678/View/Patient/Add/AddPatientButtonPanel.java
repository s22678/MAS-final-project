package s22678.View.Patient.Add;

import javax.swing.*;
import java.awt.*;

public class AddPatientButtonPanel extends JPanel {
    public AddPatientButtonPanel() {
        GridLayout gridLayout = new GridLayout();
        gridLayout.setHgap(30);
        setLayout(gridLayout);

        add(new AddPatientButton());
    }
}
