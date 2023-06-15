package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Bed class representing beds in the hospital.
 * <p>
 *     One person can be assigned to one bed during treatment. After treatment is completed the bed is no longer
 *     occupied.
 * </p>
 * <p>
 *     One bed can be assigned to a single room.
 * </p>
 */
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Bed> extent = new ArrayList<>();
    private boolean occupied;
    private Person patient;
    private Room room;
    private final int id;

    public Bed() {
        occupied = false;
        id = getNewBedId();
        extent.add(this);
    }

    /**
     * Simple getter for Bed extent
     * @return List of all Bed objects created so far, saved in an extent.
     */
    public static List<Bed> getExtent() {
        return extent;
    }

    /**
     * Setter for the Bed extent, used when loading the extent from saved file.
     * @param newExtent a saved list of Bed objects that will be loaded to the extent.
     */
    public static void setExtent(List<Bed> newExtent) {
        extent = newExtent;
    }

    /**
     * Check if the bed is occupied by the patient.
     * @return true/false - if the bed is occupied by the patient or not.
     */
    public boolean isOccupied() {
        return this.occupied;
    }

    /**
     * Get the patient assigned to the bed.
     * @return Person of type patient who represents a patient occupying the bed during treatment.
     */
    public Person getPatient() {
        if (patient.getCurrentRole() == PersonRole.PATIENT) {
            return this.patient;
        }
        return null;
    }

    /**
     * Assign the patient to the bed.
     * @param patient a Person (patient) that will occupy the bed during the treatment.
     */
    public void setPatient(Person patient) {
        if (this.patient == null && patient.getCurrentRole() == PersonRole.PATIENT) {
            this.patient = patient;
            this.occupied = true;
        }

        if(patient.getPatientBed() == null) {
            patient.setPatientBed(this);
        }
    }

    /**
     * Room getter.
     * @return Room where the bed is located.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Room setter.
     * @param room set the Room where the Bed is located.
     */
    public void setRoom(Room room) {
        if (this.room == null) {
            this.room = room;
        }

        if (!room.getBeds().contains(this)) {
            room.addBed(this);
        }
    }

    /**
     * For purpose of identifying each Bed, it is assigned an id unique to each Bed.
     * @return Bed ID.
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return
     */
    private int getNewBedId() {
        if (extent.size() == 0) {
            return 0;
        }

        int largest = 0;

        for (Bed bed : extent) {
            if (bed.getId() > largest) {
                largest = bed.getId();
            }
        }

        return ++largest;
    }

    public void freeBed() {
        this.patient.setPatientBed(null);
        this.patient = null;
        this.occupied = false;
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
