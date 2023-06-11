package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int maxBedCapacity = 5;
    private static List<Room> extent = new ArrayList<>();
    private int roomNumber;
    private List<Bed> beds = new ArrayList<>();

    public static int getMaxBedCapacity() {
        return maxBedCapacity;
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(maxBedCapacity);
        stream.writeObject(extent);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        maxBedCapacity = (int) stream.readObject();
        extent = (List<Room>) stream.readObject();
    }

    public static void printExtent() {
        System.out.println(extent);
    }

    public static List<Room> getExtent() {
        return extent;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public Room(int roomNumber) {
        if (!doesRoomWithRoomNumberExist(roomNumber)) {
            this.roomNumber = roomNumber;
        } else {
            this.roomNumber = getNewRoomNumber();
        }
        Bed bed = new Bed();
        beds.add(bed);
        bed.setRoom(this);
        extent.add(this);
    }

    public boolean doesRoomWithRoomNumberExist(int roomNumber) {
        for (Room room : extent) {
            if (room.getRoomNumber() == roomNumber) {
                return true;
            }
        }
        return false;
    }

    public void addBed(Bed bed) {
        if (!beds.contains(bed) && beds.size() < maxBedCapacity) {
            beds.add(bed);
        }

        if (bed.getRoom() == null) {
            bed.setRoom(this);
        }
    }

    public List<Bed> getBeds() {
        return beds;
    }

    private int getNewRoomNumber() {
        int newNumber = 0;

        for (Room room : extent) {
            if (room.roomNumber > newNumber) {
                newNumber = room.roomNumber;
            }
        }
        return ++newNumber;
    }
}
