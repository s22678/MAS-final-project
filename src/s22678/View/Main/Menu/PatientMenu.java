package s22678.View.Main.Menu;

import s22678.View.Main.MainView;
import s22678.View.Patient.Add.AddPatientFrame;
import s22678.View.Patient.List.ListPatientActionListener;

import javax.swing.*;

import static s22678.View.Main.MainView.getSerifFont;

public class PatientMenu extends JMenu {
    public PatientMenu(String name) {
        super(name);
        setFont(getSerifFont());
        JMenuItem showPatientItem = new JMenuItem("List Patients");
        showPatientItem.setFont(getSerifFont());
        showPatientItem.addActionListener(e -> {
            System.out.println("changing view to listPatientPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listPatientPanel");
            ListPatientActionListener.reload();
        });
        JMenuItem addPatientItem = new JMenuItem("Add Patient");
        addPatientItem.setFont(getSerifFont());
        addPatientItem.addActionListener(e -> {
            JFrame addPatientWindow = new AddPatientFrame();
            addPatientWindow.setVisible(true);
        });

        add(showPatientItem);
        add(addPatientItem);
    }
}
