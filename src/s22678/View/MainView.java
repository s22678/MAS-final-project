package s22678.View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create file menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(new Font("Serif,", Font.PLAIN, 24));

            JMenuItem exitItem = new JMenuItem("Exit");
            exitItem.setFont(new Font("Serif,", Font.PLAIN, 24));
            exitItem.addActionListener((event) -> System.exit(0));
            fileMenu.add(exitItem);

        // Create management menu
        JMenu managementMenu = new JMenu("Management");
        JMenuItem option1Item = new JMenuItem("Option 1");
        JMenuItem option2Item = new JMenuItem("Option 2");
        managementMenu.add(option1Item);
        managementMenu.add(option2Item);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(managementMenu);

        // Set the menu bar
        setJMenuBar(menuBar);
    }
}

