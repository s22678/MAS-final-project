package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Bed> extent = new ArrayList<>();
    private boolean occupied;
    private Person patient;
    private Room room;

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Bed>) stream.readObject();
    }

    public static void printExtent() {
        System.out.println(extent);
    }

    public static List<Bed> getExtent() {
        return extent;
    }

    public Bed() {
        occupied = false;
        extent.add(this);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        if (this.room == null) {
            this.room = room;
        }

        if (!room.getBeds().contains(this)) {
            room.addBed(this);
        }
    }

    public void setPatient(Person patient) {
        if (this.patient == null && patient.getCurrentRole() == PersonRole.PATIENT) {
            this.patient = patient;
            this.occupied = true;
        }

        if(patient.getPatientBed() == null) {
            patient.setPatientBed(this);
        }
    }

    public Person getPatient() {
        if (patient.getCurrentRole() == PersonRole.PATIENT) {
            return this.patient;
        }
        return null;
    }

    public void freeBed() {
        this.patient.setPatientBed(null);
        this.patient = null;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public static Bed getAvailableBed() {
        for (Bed bed : extent) {
            if (!bed.isOccupied()) {
                return bed;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (occupied) {
            return "Bed{" +
                    "occupied=" + occupied +
                ", patient=" + patient.getFirstName() + " " + patient.getLastName() +
                ", room=" + room.getRoomNumber() +
                    '}';
        }
        return "Bed{" +
                "occupied=" + occupied +
                '}';
    }
}
