package s22678.View.Treatment.Show;

import s22678.Model.Treatment;

import javax.swing.*;

import static s22678.View.Main.MainView.serifFont;

public class EndTreatmentButton extends JButton {
    public EndTreatmentButton(String name, Treatment treatment) {
        super(name);
        setFont(serifFont);

        addActionListener(e -> {
            treatment.finishTreatment();
        });
    }
}
