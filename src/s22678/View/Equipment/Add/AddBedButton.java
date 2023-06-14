package s22678.View.Equipment.Add;

import s22678.Model.Bed;
import s22678.Model.Room;
import s22678.View.CustomSwingClasses.CustomJButton;
import s22678.View.CustomSwingClasses.CustomJLabel;
import s22678.View.CustomSwingClasses.CustomJTextField;

import javax.swing.*;

public class AddBedButton extends CustomJButton {
    public AddBedButton() {
        setText("Add");

        CustomJTextField roomTextField = AddBedTextPanel.getAddBedTextPanel().getRoomTextField();

        addActionListener(e -> {
            Room room = Room.findByNumber(Integer.parseInt(roomTextField.getText()));
            if (room == null) {
                JOptionPane.showMessageDialog(this, new CustomJLabel("The room with number " + roomTextField.getText() + " doesn't exist"), "Room Number Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(room.getBeds().size() < Room.getMaxBedCapacity())) {
                JOptionPane.showMessageDialog(this, new CustomJLabel("The room with number " + roomTextField.getText() + " doesn't have enough space for a new bed"), "Room Full Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bed bed = new Bed();
                room.addBed(bed);

                JOptionPane.showMessageDialog(this, new CustomJLabel("Bed added to room nr: " + room.getRoomNumber()));
            }
        });
    }
}
