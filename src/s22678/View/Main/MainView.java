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
    private static final int textFieldHeight = 50;
    private static final int textFieldWidth = 200;
    private static final int screenWidth = 1536;
    private static final int screenHeight = 864;
    private static final int fontSize = 30;
    private static final Font serifFont = new Font("Serif,", Font.PLAIN, fontSize);
    private static final Font sansSerifFont = new Font("SansSerif,", Font.PLAIN, fontSize);
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

        mainPanel.add("listPatientPanel", new ListPatientPanel());
        mainPanel.add("listDoctorPanel", new ListDoctorPanel());
        mainPanel.add("listRoomAndBedPanel", new ListRoomAndBedPanel());
        mainPanel.add("listDoctorWithPatientPanel", new ListDoctorWithPatientPanel());
        mainPanel.add("listSelectedPatientPanel", new ListSelectedPatientPanel());
        mainPanel.add("defaultPanel", new DefaultPanel());

        add(mainPanel);
        setJMenuBar(new MainMenuBar());
        setVisible(true);
    }


    public static int getTextFieldHeight() {
        return textFieldHeight;
    }
    public static int getTextFieldWidth() {
        return textFieldWidth;
    }
    public static int getScreenWidth() {
        return screenWidth;
    }
    public static int getScreenHeight() {
        return screenHeight;
    }
    public static Font getSerifFont() {
        return serifFont;
    }
    public static Font getSansSerifFont() {
        return sansSerifFont;
    }
    public static CardLayout getCardLayout() {
        return cardLayout;
    }
    public static JPanel getMainPanel() {
        return mainPanel;
    }
}

