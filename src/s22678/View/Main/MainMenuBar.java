package s22678.View.Main;

import s22678.Controller.MainController;
import s22678.Model.*;
import s22678.View.Doctor.Add.AddDoctorWindow;
import s22678.View.Patient.Add.AddPatientWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static s22678.View.Main.MainView.serifFont;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {
        // File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(serifFont);
        fileMenu.setMnemonic(KeyEvent.ALT_DOWN_MASK | KeyEvent.getExtendedKeyCodeForChar('F'));

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setFont(serifFont);
        loadItem.setMnemonic(KeyEvent.VK_L);
        loadItem.addActionListener((event) -> {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(".\\save"));
                    int result = fileChooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // Process the selected file
                        System.out.println("Selected load file: " + selectedFile.getAbsolutePath());
                        try {
                            MainController.load(selectedFile.getAbsolutePath());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "can't load the file - bad format or not enough significant permissions", "File Load Error", JOptionPane.ERROR_MESSAGE);
                        }

                        System.out.println("łóżka");
                        java.util.List<Bed> beds = Bed.getExtent();
                        System.out.println(beds);
                        System.out.println("karty pacjenta");
                        PatientCard.printExtent();
                        System.out.println("osoby");
                        Person.printExtent();
                        System.out.println("pokoje");
                        Room.printExtent();
                        System.out.println("leczenia");
                        List<Treatment> treatments = Treatment.getExtent();
                        System.out.println(treatments);
                    }
                }
        );
        fileMenu.add(loadItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setFont(serifFont);
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.addActionListener((event) -> {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(".\\save"));
                    int result = fileChooser.showOpenDialog(this);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        // Process the selected file
                        System.out.println("Selected save file: " + selectedFile.getAbsolutePath());
                        try {
                            MainController.save(selectedFile.getAbsolutePath());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "can't save the file - bad format or not enough significant permissions", "File Save Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );
        fileMenu.add(saveItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(serifFont);
        exitItem.setMnemonic(KeyEvent.VK_Q);
        exitItem.addActionListener((event) -> System.exit(0));
        fileMenu.add(exitItem);

        // Patient menu
        JMenu patientMenu = new JMenu("Patient");
        patientMenu.setFont(serifFont);
        JMenuItem showPatientItem = new JMenuItem("List Patients");
        showPatientItem.setFont(serifFont);
        showPatientItem.addActionListener(e -> {
            System.out.println("changing view");
            MainView.getCardLayout().show(MainView.getMainPanel(), "patientListPanel");
        });
        JMenuItem addPatientItem = new JMenuItem("Add Patient");
        addPatientItem.setFont(serifFont);
        addPatientItem.addActionListener(e -> {
            JFrame addPatientWindow = new AddPatientWindow();
            addPatientWindow.setVisible(true);
        });

        patientMenu.add(showPatientItem);
        patientMenu.add(addPatientItem);

        // Doctor menu
        JMenu doctorMenu = new JMenu("Doctor");
        doctorMenu.setFont(serifFont);
        JMenuItem showDoctorItem = new JMenuItem("List Doctors");
        showDoctorItem.setFont(serifFont);
        showDoctorItem.addActionListener(e -> {
            System.out.println("changing view");
            MainView.getCardLayout().show(MainView.getMainPanel(), "doctorListPanel");
        });
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        addDoctorItem.setFont(serifFont);
        addDoctorItem.addActionListener(e -> {
            JFrame addDoctorWindow = new AddDoctorWindow();
            addDoctorWindow.setVisible(true);
        });

        doctorMenu.add(showDoctorItem);
        doctorMenu.add(addDoctorItem);

        // Equipment menu
        JMenu equipmentMenu = new JMenu("Equipment");
        equipmentMenu.setFont(serifFont);
        JMenuItem showRoomItem = new JMenuItem("List Rooms and Beds");
        showDoctorItem.setFont(serifFont);
        showDoctorItem.addActionListener(e -> {
            System.out.println("changing view");
            MainView.getCardLayout().show(MainView.getMainPanel(), "equipmentListPanel");
        });
        JMenuItem addRoomItem = new JMenuItem("Add Room");
        addRoomItem.setFont(serifFont);
        addRoomItem.addActionListener(e -> {
            JFrame addDoctorWindow = new AddDoctorWindow();
            addDoctorWindow.setVisible(true);
        });
        JMenuItem addBedItem = new JMenuItem("Add Bed");
        addBedItem.setFont(serifFont);
        addBedItem.addActionListener(e -> {
            JFrame addDoctorWindow = new AddDoctorWindow();
            addDoctorWindow.setVisible(true);
        });

        equipmentMenu.add(showRoomItem);
        equipmentMenu.add(addRoomItem);
        equipmentMenu.add(addBedItem);

        // Add menus to the menu bar
        add(fileMenu);
        add(patientMenu);
        add(doctorMenu);
        add(equipmentMenu);

        // Set the menu bar
    }
}
