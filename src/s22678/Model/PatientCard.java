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
    private List<Treatment> patientHistory = new ArrayList<>();
    private static List<PatientCard> extent = new ArrayList<>();

    public PatientCard() {
        extent.add(this);
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<PatientCard>) stream.readObject();
    }

    public static void printExtent() {
        System.out.println(extent);
    }

    public static List<PatientCard> getExtent() {
        return extent;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        if(this.patient == null) {
            this.patient = patient;
        }

        if (patient.getPatientCard() == null) {
            patient.setPatientCard(this);
        }
    }

    public List<Treatment> getPatientHistory() {
        return patientHistory;
    }

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
//                "patient=" + patient.getFirstName() + patient.getLastName() +
                "treatments= " + patientHistory.stream().count() +
                '}';
    }
}
