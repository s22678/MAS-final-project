package s22678.View.Patient.Show;

import s22678.Model.Person;
import javax.swing.*;
import java.awt.*;

public class ShowPatientBottomPanel extends JPanel {
    public ShowPatientBottomPanel(Person patient) {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new ShowPatientHistoryTable(patient));
        add(scrollPane);
    }
}
