package s22678.View.Main.Menu;

import s22678.Controller.MainController;
import s22678.Model.*;
import s22678.View.Doctor.Add.AddDoctorWindow;
import s22678.View.Doctor.List.ListDoctorActionListener;
import s22678.View.Equipment.Add.AddBedWindow;
import s22678.View.Equipment.List.ListRoomAndBedActionListener;
import s22678.View.Main.MainView;
import s22678.View.Patient.Add.AddPatientWindow;
import s22678.View.Patient.List.ListPatientActionListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static s22678.View.Main.MainView.serifFont;

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
