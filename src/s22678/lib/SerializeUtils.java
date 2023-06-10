package s22678.lib;

import s22678.Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeUtils {
    private final static String fileDir = ".\\save";
    private final static String fileName = fileDir + "\\File.dat";

    public static void save() {
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

    public static void load() {
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