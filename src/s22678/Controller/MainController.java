package s22678.Controller;

import s22678.Model.*;

import java.io.*;

public class MainController {
    private final static String fileDir = ".\\save";
    private final static String fileName = fileDir + "\\File.dat";

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
}