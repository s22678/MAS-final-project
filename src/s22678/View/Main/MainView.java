package s22678.View.Main;

import s22678.View.Doctor.List.ListDoctorPanel;
import s22678.View.Equipment.List.ListRoomAndBedPanel;
import s22678.View.Main.Menu.MainMenuBar;
import s22678.View.Patient.List.ListPatientPanel;
import s22678.View.Treatment.SelectDoctor.ListDoctorWithPatientPanel;
import s22678.View.Treatment.SelectPatient.ListSelectedPatientPanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public static final int screenWidth = 1536;
    public static final int screenHeight = 864;
    public static final int fontSize = 30;
    public static final Font serifFont = new Font("Serif,", Font.PLAIN, fontSize);
    public static final Font sansSerifFont = new Font("SansSerif,", Font.PLAIN, fontSize);
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    public MainView() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        JPanel listPatientPanel = new ListPatientPanel();
        JPanel listDoctorPanel = new ListDoctorPanel();
        JPanel listRoomAndBedPanel = new ListRoomAndBedPanel();
        JPanel listDoctorWithPatientPanel = new ListDoctorWithPatientPanel();
        JPanel listSelectedPatientPanel = new ListSelectedPatientPanel();
        JPanel defaultPanel = new DefaultPanel();

        mainPanel.add("listPatientPanel", listPatientPanel);
        mainPanel.add("listDoctorPanel", listDoctorPanel);
        mainPanel.add("listRoomAndBedPanel", listRoomAndBedPanel);
        mainPanel.add("listDoctorWithPatientPanel", listDoctorWithPatientPanel);
        mainPanel.add("listSelectedPatientPanel", listSelectedPatientPanel);
        mainPanel.add("defaultPanel", defaultPanel);

        add(mainPanel);
        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }

    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }
}

