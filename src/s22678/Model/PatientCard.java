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
    private static List<PatientCard> patientCardExtent = new ArrayList<>();

    public PatientCard() {
        patientCardExtent.add(this);
    }

    public static void saveBeds(ObjectOutputStream stream) throws IOException {
        try {
            stream.writeObject(patientCardExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadBeds(ObjectInputStream stream) throws IOException {
        try {
            patientCardExtent = (ArrayList<PatientCard>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        if(this.patient == null) {
            this.patient = patient;
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
