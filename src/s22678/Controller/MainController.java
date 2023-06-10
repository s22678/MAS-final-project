package s22678.Controller;

import s22678.Model.*;

import java.io.*;

public class MainController {
    private final static String fileDir = ".\\save";
    private final static String fileName = fileDir + "\\File.dat";

    public static void save(String absolutePath) {
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));

            Bed.save(stream);
            PatientCard.save(stream);
            Person.save(stream);
            Room.save(stream);
            Treatment.save(stream);

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(String absolutePath) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName));

            Bed.load(stream);
            PatientCard.load(stream);
            Person.load(stream);
            Room.load(stream);
            Treatment.load(stream);

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}