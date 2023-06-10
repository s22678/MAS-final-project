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
    private static List<Room> roomExtent = new ArrayList<>();
    private int roomNumber;
    private List<Bed> beds = new ArrayList<>();

    public static int getMaxBedCapacity() {
        return maxBedCapacity;
    }

    public static void saveRooms(ObjectOutputStream stream) throws IOException {
        try {
            stream.writeObject(maxBedCapacity);
            stream.writeObject(roomExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadRooms(ObjectInputStream stream) throws IOException {
        try {
            maxBedCapacity = (int) stream.readObject();
            roomExtent = (List<Room>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        beds.add(new Bed());
        roomExtent.add(this);
    }

    public boolean doesRoomWithRoomNumberExist(int roomNumber) {
        for (Room room : roomExtent) {
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

        for (Room room : roomExtent) {
            if (room.roomNumber > newNumber) {
                newNumber = room.roomNumber;
            }
        }
        return ++newNumber;
    }
}
