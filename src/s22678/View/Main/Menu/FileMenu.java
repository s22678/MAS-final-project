package s22678.View.Main.Menu;

import s22678.Controller.MainController;
import s22678.Model.*;
import s22678.View.CustomSwingClasses.CustomJLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static s22678.Controller.MainController.reloadData;
import static s22678.View.Main.MainView.getSerifFont;

public class FileMenu extends JMenu {
    public FileMenu (String name) {
        super(name);
        setFont(getSerifFont());
        setMnemonic(KeyEvent.ALT_DOWN_MASK | KeyEvent.getExtendedKeyCodeForChar('F'));

        JMenuItem newItem = new JMenuItem("New File");
        newItem.setFont(getSerifFont());
        newItem.setMnemonic(KeyEvent.VK_L);
        newItem.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog((Component) null, new CustomJLabel("This will remove all unsaved changes! Continue?"),"alert", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                MainController.newFile();
                reloadData();
            }
        });

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setFont(getSerifFont());
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
                            JOptionPane.showMessageDialog(this, new CustomJLabel("can't load the file - bad format or not enough significant permissions"), "File Load Error", JOptionPane.ERROR_MESSAGE);
                        }

                        System.out.println("łóżka");
                        System.out.println(Bed.getExtent());

                        System.out.println("karty pacjenta");
                        System.out.println(PatientCard.getExtent());

                        System.out.println("osoby");
                        System.out.println(Person.getExtent());

                        System.out.println("pokoje");
                        System.out.println(Room.getExtent());

                        System.out.println("leczenia");
                        System.out.println( Treatment.getExtent());

                        reloadData();
                    }
                }
        );


        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setFont(getSerifFont());
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
                            JOptionPane.showMessageDialog(this, new CustomJLabel("can't save the file - bad format or not enough significant permissions"), "File Save Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(getSerifFont());
        exitItem.setMnemonic(KeyEvent.VK_Q);
        exitItem.addActionListener((event) -> System.exit(0));

        add(newItem);
        add(loadItem);
        add(saveItem);
        add(exitItem);
    }
}
