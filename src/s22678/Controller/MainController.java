package s22678.Controller;

import s22678.Model.*;
import s22678.View.Doctor.List.ListDoctorActionListener;
import s22678.View.Equipment.List.ListRoomAndBedActionListener;
import s22678.View.Patient.List.ListPatientActionListener;

import java.io.*;

public class MainController {

    public static void save(String absolutePath) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(absolutePath));

        Bed.save(stream);
        PatientCard.save(stream);
        Person.save(stream);
        Room.save(stream);
        Treatment.save(stream);

        stream.close();
    }

    public static void load(String absolutePath) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(absolutePath));

        Bed.load(stream);
        PatientCard.load(stream);
        Person.load(stream);
        Room.load(stream);
        Treatment.load(stream);

        stream.close();
    }

    public static void newFile() {
        Bed.newFile();
        PatientCard.newFile();
        Person.newFile();
        Room.newFile();
        Treatment.newFile();
    }

    public static void reloadData() {
        ListDoctorActionListener.action();
        ListPatientActionListener.action();
        ListRoomAndBedActionListener.action();
    }
}