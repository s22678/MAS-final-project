package s22678.View.Main;

import s22678.Controller.MainController;
import s22678.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static s22678.View.Main.MainView.serifFont;

public class MainViewBackup extends JFrame {
    private static final int fontSize = 30;
    public MainViewBackup() {
        setTitle("Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create file menu
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
                        MainController.load(selectedFile.getAbsolutePath());

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
                        MainController.save(selectedFile.getAbsolutePath());
                    }
                }
        );
        fileMenu.add(saveItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(serifFont);
        exitItem.setMnemonic(KeyEvent.VK_Q);
        exitItem.addActionListener((event) -> System.exit(0));
        fileMenu.add(exitItem);

        // Create patient menu
        JMenu patientMenu = new JMenu("Patient");
        patientMenu.setFont(serifFont);
        JMenuItem showPatientItem = new JMenuItem("Show Patients");
        showPatientItem.setFont(serifFont);
        showPatientItem.addActionListener(e -> {

        });
        JMenuItem addPatientItem = new JMenuItem("Add Patient");
        addPatientItem.setFont(serifFont);
        JMenuItem removePatientItem = new JMenuItem("Remove Patient");
        removePatientItem.setFont(serifFont);

        patientMenu.add(showPatientItem);
        patientMenu.add(addPatientItem);
        patientMenu.add(removePatientItem);

        // Create doctor menu
        JMenu doctorMenu = new JMenu("Doctor");
        doctorMenu.setFont(serifFont);
        JMenuItem showDoctorItem = new JMenuItem("Show Doctor");
        showDoctorItem.setFont(serifFont);
        JMenuItem addDoctorItem = new JMenuItem("Add Doctor");
        addDoctorItem.setFont(serifFont);
        JMenuItem removeDoctorItem = new JMenuItem("Remove Doctor");
        removeDoctorItem.setFont(serifFont);
        JMenuItem manageDoctor = new JMenuItem("Manage Doctor");
        manageDoctor.setFont(serifFont);

        doctorMenu.add(showDoctorItem);
        doctorMenu.add(addDoctorItem);
        doctorMenu.add(removeDoctorItem);
        doctorMenu.add(manageDoctor);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(patientMenu);
        menuBar.add(doctorMenu);

        // Set the menu bar
        setJMenuBar(menuBar);
    }
}

