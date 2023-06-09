package s22678.Model;

import java.util.ArrayList;
import java.util.List;

public class PatientCard {
    Person.Patient patient;
    List<Treatment> patientHistory = new ArrayList<>();

    public Person.Patient getPatient() {
        return patient;
    }

    public void setPatient(Person.Patient patient) {
        if(this.patient == null) {
            this.patient = patient;
        }
    }

    public List<Treatment> getPatientHistory() {
        return patientHistory;
    }

    public void addToPatientHistory(Treatment treatment) {
        if(!patientHistory.contains(treatment)) {
            patientHistory.add(treatment);
        }

        if (treatment.getPatientCard() == null){
            treatment.setPatientCard(this);
        }
    }
}
