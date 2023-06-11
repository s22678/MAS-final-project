package s22678.View.Equipment.Add;

import s22678.Model.Bed;
import s22678.Model.DoctorField;
import s22678.Model.Person;
import s22678.Model.Room;

import javax.swing.*;
import java.awt.*;

import static s22678.View.Main.MainView.serifFont;

public class AddBedWindow extends JFrame {
    public static final int textFieldHeight = 50;
    public static final int textFieldWidth = 200;

    public AddBedWindow() {
        setTitle("Add Bed");
//        setLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1536, 864);
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
                JOptionPane.showMessageDialog(this, "The room with number" + roomTextField.getText() + " doesn't exist" , "Room Number Error", JOptionPane.ERROR_MESSAGE);
            } else if (!(room.getBeds().size() < Room.getMaxBedCapacity())){
                JOptionPane.showMessageDialog(this, "The room with number" + roomTextField.getText() + " doesn't have enough space for a new bed" , "Room Full Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Bed bed = new Bed();
                room.addBed(bed);
                JOptionPane.showMessageDialog(this, "Bed added to room nr: " + room.getRoomNumber());
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
