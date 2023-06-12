package s22678.View.Equipment.Add;

import s22678.Model.Bed;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.Model.Room;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.*;

public class AddBedFrame extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;

    public AddBedFrame() {
        setTitle("Add Bed");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);

        JPanel masterPanel =  new JPanel(new GridLayout(1 ,2));

        GridLayout labelLayout = new GridLayout(1 ,1);
        labelLayout.setVgap(40);
        JPanel labelContainer = new JPanel(labelLayout);

        GridLayout textFieldLayout = new GridLayout(1 ,1);
        textFieldLayout.setVgap(40);
        JPanel textFieldContainer = new JPanel(textFieldLayout);

        JTextField roomTextField = new JTextField();
        roomTextField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
        roomTextField.setFont(serifFont);

        JLabel roomLabel = new JLabel("Select room for the bed", SwingConstants.CENTER);
        roomLabel.setFont(serifFont);

        textFieldContainer.add(roomTextField);

        labelContainer.add(roomLabel);

        GridLayout buttonContainerLayout = new GridLayout();
        buttonContainerLayout.setHgap(30);
        JPanel buttonPanel = new JPanel(buttonContainerLayout);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            Room room = Room.findByNumber(Integer.parseInt(roomTextField.getText()));
            if (room == null) {
                JLabel label = new JLabel("The room with number" + roomTextField.getText() + " doesn't exist");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Room Number Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(room.getBeds().size() < Room.getMaxBedCapacity())){
                JLabel label = new JLabel("The room with number" + roomTextField.getText() + " doesn't have enough space for a new bed");
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label, "Room Full Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bed bed = new Bed();
                room.addBed(bed);
                JLabel label = new JLabel("Bed added to room nr: " + room.getRoomNumber());
                label.setFont(serifFont);
                JOptionPane.showMessageDialog(this, label);
            }
        });

        buttonPanel.add(addButton);

        masterPanel.add(labelContainer);
        masterPanel.add(textFieldContainer);

        add(masterPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
