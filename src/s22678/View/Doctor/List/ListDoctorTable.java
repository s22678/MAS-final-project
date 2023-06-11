package s22678.View.Doctor.List;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static s22678.View.Main.MainView.sansSerifFont;

public class ListDoctorTable extends JTable {
    private static DefaultTableModel tableModel;
    public ListDoctorTable() {
        setRowHeight(this.getRowHeight() + 35);
        setFont(sansSerifFont);
        getTableHeader().setFont(sansSerifFont);
        getTableHeader().setResizingAllowed(true);
        String[] columnNames = {"First Name", "Last Name", "Specialization"};
        tableModel = new DefaultTableModel(columnNames, 0);
        setModel(tableModel);

        for (Person person : Person.getExtent().values()) {
            if (person.getRole() == PersonRole.DOCTOR)
                tableModel.addRow(person.getDoctorTableData());
        }

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    int row = getSelectedRow();
//                    String name = (String) getValueAt(row, 0);
//                    String age = getValueAt(row, 1).toString();
//                    String email = (String) getValueAt(row, 2);
//
//                    JFrame newFrame = new JFrame("Details");
//                    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    newFrame.setSize(300, 200);
//                    newFrame.setLayout(new FlowLayout());
//
//                    JLabel nameLabel = new JLabel("Name: " + name);
//                    JLabel ageLabel = new JLabel("Age: " + age);
//                    JLabel emailLabel = new JLabel("Email: " + email);
//
//                    newFrame.add(nameLabel);
//                    newFrame.add(ageLabel);
//                    newFrame.add(emailLabel);
//
//                    newFrame.setVisible(true);
//                }
//            }
//        });
    }

    public static DefaultTableModel getDefaultTableModel() {
        return tableModel;
    }
}
