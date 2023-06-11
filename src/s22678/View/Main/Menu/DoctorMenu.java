package s22678.View.Main.Menu;

import s22678.View.Doctor.Add.AddDoctorWindow;
import s22678.View.Doctor.List.ListDoctorActionListener;
import s22678.View.Main.MainView;

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
            ListDoctorActionListener.action();
        });
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        addDoctorItem.setFont(serifFont);
        addDoctorItem.addActionListener(e -> {
            JFrame addDoctorWindow = new AddDoctorWindow();
            addDoctorWindow.setVisible(true);
        });

        add(showDoctorItem);
        add(addDoctorItem);
    }
}
