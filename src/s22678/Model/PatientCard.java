package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientCard implements Serializable {
    private static final long serialVersionUID = 1L;
    private Person patient;
    private final List<Treatment> patientHistory = new ArrayList<>();
    private static List<PatientCard> extent = new ArrayList<>();

    public PatientCard() {
        extent.add(this);
    }

    /**
     * Remove all PatientCard objects from the extent.
     */
    public static void newFile() {
        extent.removeAll(extent);
    }

    /**
     * Save the PatientCard objects from the extent to the save file.
     * @param stream stream of data for a save file.
     * @throws IOException
     */
    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    /**
     * Load data from file and save it in the PatientCard extent.
     * @param stream stream of data from the save file.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<PatientCard>) stream.readObject();
    }

    /**
     * Simple getter for PatientCard extent
     * @return List of all PatientCard objects created so far, saved in an extent.
     */
    public static List<PatientCard> getExtent() {
        return extent;
    }

    /**
     * Return the patient affected by the treatments in the patient card.
     * @return patient with history of treatments.
     */
    public Person getPatient() {
        return patient;
    }

    /**
     * Create association between a patient and this history treatment card.
     * @param patient
     */
    public void setPatient(Person patient) {
        if(this.patient == null) {
            this.patient = patient;
        }

        if (patient.getPatientCard() == null) {
            patient.setPatientCard(this);
        }
    }

    /**
     * Get the history of all Treatments of the patient who owns this Patient Card.
     * @return list of all Patient's treatments.
     */
    public List<Treatment> getPatientHistory() {
        return patientHistory;
    }

    /**
     * When the patient's treatment is over, save that treatment to patient's history in Patient's Card.
     * @param treatment of the patient by the doctor.
     */
    public void addTreatmentToPatientHistory(Treatment treatment) {
        if(!patientHistory.contains(treatment)) {
            patientHistory.add(treatment);
        }

        if (treatment.getPatientCard() == null){
            patient.getPatientTreatment().setPatientCard();
        }
    }

    @Override
    public String toString() {
        return "PatientCard{" +
                "treatments= " + patientHistory.stream().count() +
                '}';
    }
}
