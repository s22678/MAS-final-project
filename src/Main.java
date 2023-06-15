import s22678.Model.*;
import s22678.View.Main.MainView;
import s22678.Controller.MainController;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        SwingUtilities.invokeLater(() -> {
            MainView menu = new MainView();
            menu.setVisible(true);
        });
    }
}