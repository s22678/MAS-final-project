package s22678.View.Main.Menu;

import s22678.Controller.MainController;
import s22678.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import static s22678.Controller.MainController.reloadData;
import static s22678.View.Main.MainView.serifFont;

public class FileMenu extends JMenu {
    public FileMenu (String name) {
        super(name);
        setFont(serifFont);
        setMnemonic(KeyEvent.ALT_DOWN_MASK | KeyEvent.getExtendedKeyCodeForChar('F'));

        JMenuItem newItem = new JMenuItem("New File");
        newItem.setFont(serifFont);
        newItem.setMnemonic(KeyEvent.VK_L);
        newItem.addActionListener(e -> {
            JLabel label = new JLabel("This will remove all unsaved changes! Continue?");
            label.setFont(serifFont);
            int result = JOptionPane.showConfirmDialog((Component) null, label,"alert", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                MainController.newFile();
                reloadData();
            }
        });

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
                            JLabel label = new JLabel("can't load the file - bad format or not enough significant permissions");
                            label.setFont(serifFont);
                            JOptionPane.showMessageDialog(this, label, "File Load Error", JOptionPane.ERROR_MESSAGE);
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

                        reloadData();
                    }
                }
        );


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
                            JLabel label = new JLabel("can't save the file - bad format or not enough significant permissions");
                            label.setFont(serifFont);
                            JOptionPane.showMessageDialog(this, label, "File Save Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
        );

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(serifFont);
        exitItem.setMnemonic(KeyEvent.VK_Q);
        exitItem.addActionListener((event) -> System.exit(0));

        add(newItem);
        add(loadItem);
        add(saveItem);
        add(exitItem);
    }
}
