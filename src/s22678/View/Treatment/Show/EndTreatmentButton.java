package s22678.View.Treatment.Show;

import s22678.Model.Treatment;
import s22678.View.CustomSwingClasses.CustomJButton;

public class EndTreatmentButton extends CustomJButton {
    public EndTreatmentButton(String text, Treatment treatment) {
        super(text);

        addActionListener(e -> {
            treatment.finishTreatment();
        });
    }
}
