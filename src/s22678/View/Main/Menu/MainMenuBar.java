package s22678.View.Main.Menu;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {

        // File menu
        JMenu fileMenu = new FileMenu("File");

        // Patient menu
        JMenu patientMenu = new PatientMenu("Patient");

        // Doctor menu
        JMenu doctorMenu = new DoctorMenu("Doctor");

        // Equipment menu
        JMenu equipmentMenu = new EquipmentMenu("Equipment");

        // Add menus to the menu bar
        add(fileMenu);
        add(patientMenu);
        add(doctorMenu);
        add(equipmentMenu);
    }
}
