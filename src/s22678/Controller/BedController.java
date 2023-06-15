package s22678.Controller;

import s22678.Model.Bed;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BedController {
    public static void newFile() {
        Bed.getExtent().removeAll(Bed.getExtent());
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(Bed.getExtent());
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Bed.setExtent((ArrayList<Bed>) stream.readObject());
    }

    public static Bed getAvailableBed() {
        for (Bed bed : Bed.getExtent()) {
            if (!bed.isOccupied()) {
                return bed;
            }
        }
        return null;
    }
}
