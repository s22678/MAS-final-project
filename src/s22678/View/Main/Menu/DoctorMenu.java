package s22678.View.Main.Menu;

import s22678.View.Doctor.Add.AddDoctorFrame;
import s22678.View.Doctor.List.ListDoctorActionListener;
import s22678.View.Main.MainView;
import s22678.View.Treatment.SelectDoctor.ListDoctorWithPatientActionListener;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class DoctorMenu extends JMenu {
    public DoctorMenu(String name) {
        super(name);
        setFont(serifFont);
        JMenuItem showDoctorItem = new JMenuItem("List Doctors");
        showDoctorItem.setFont(serifFont);
        showDoctorItem.addActionListener(e -> {
            System.out.println("changing view to listDoctorPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listDoctorPanel");
            ListDoctorActionListener.reload();
        });
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        addDoctorItem.setFont(serifFont);
        addDoctorItem.addActionListener(e -> {
            JFrame addDoctorWindow = new AddDoctorFrame();
            addDoctorWindow.setVisible(true);
        });

        JMenuItem selectTreatmentItem = new JMenuItem("Select Treatment");
        selectTreatmentItem.setFont(serifFont);
        selectTreatmentItem.addActionListener(e -> {
            System.out.println("changing view to listDoctorWithPatientPanel");
            MainView.getCardLayout().show(MainView.getMainPanel(), "listDoctorWithPatientPanel");
            ListDoctorWithPatientActionListener.reload();
        });

        add(showDoctorItem);
        add(addDoctorItem);
        add(selectTreatmentItem);
    }
}
