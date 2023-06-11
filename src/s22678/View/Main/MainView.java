package s22678.View.Main;

import s22678.View.Patient.List.ListPatientPanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public static final int fontSize = 30;
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    public MainView() {
        setTitle("Hospital Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1536, 864);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel();
        mainPanel.setLayout(cardLayout);

        JPanel patientListPanel = new ListPatientPanel();
        JPanel defaultPanel = new DefaultPanel();

        mainPanel.add("patientListPanel", patientListPanel);
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

