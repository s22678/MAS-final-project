package s22678.View.Patient;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListPatientPanel extends JPanel {
    public ListPatientPanel() {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new ListPatientTable());
        JButton refreshButton = new JButton("Refresh");
        add(scrollPane, BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);
    }
}
