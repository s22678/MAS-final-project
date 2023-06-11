package s22678.View.Main.Menu;

import s22678.View.Main.MainView;
import s22678.View.Patient.Add.AddPatientWindow;
import s22678.View.Patient.List.ListPatientActionListener;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class PatientMenu extends JMenu {
    public PatientMenu(String name) {
        super(name);
        setFont(serifFont);
        JMenuItem showPatientItem = new JMenuItem("List Patients");
        showPatientItem.setFont(serifFont);
        showPatientItem.addActionListener(e -> {
            System.out.println("changing view to listPatientPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listPatientPanel");
            ListPatientActionListener.action();
        });
        JMenuItem addPatientItem = new JMenuItem("Add Patient");
        addPatientItem.setFont(serifFont);
        addPatientItem.addActionListener(e -> {
            JFrame addPatientWindow = new AddPatientWindow();
            addPatientWindow.setVisible(true);
        });

        add(showPatientItem);
        add(addPatientItem);
    }
}
