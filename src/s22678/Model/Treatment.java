package s22678.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Treatment {
    private PatientCard patientCard;
    private Person doctor;
    private Person patient;
    private List<String> prescribedMedicine = new ArrayList<>();
    private boolean isOperationNeeded;
    private LocalDate treatmentStart;
    private LocalDate treatmentEnd;
    private String afterTreatmentHealtState;

    public Treatment() {
    }

    public PatientCard getPatientCard() {
        return patientCard;
    }

    public void setPatientCard(PatientCard patientCard) {
        if(this.patientCard == null) {
            this.patientCard = patientCard;
            patientCard.addToPatientHistory(this);
        }
    }

    public void startTreatment() {
        treatmentStart = LocalDate.now();
    }

    public Person getPerson(PersonRole role) {
        if (role == PersonRole.PATIENT) {
            return patient;
        }
        return doctor;
    }

    public void setPerson(Person person, PersonRole role) {
        if
    }

    public List<String> getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(List<String> prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public boolean isOperationNeeded() {
        return isOperationNeeded;
    }

    public void setOperationNeeded(boolean operationNeeded) {
        isOperationNeeded = operationNeeded;
    }

    public LocalDate getTreatmentStart() {
        return treatmentStart;
    }

    public void setTreatmentStart(LocalDate treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    public LocalDate getTreatmentEnd() {
        return treatmentEnd;
    }

    public void setTreatmentEnd(LocalDate treatmentEnd) {
        this.treatmentEnd = treatmentEnd;
    }

    public String getAfterTreatmentHealtState() {
        return afterTreatmentHealtState;
    }

    public void setAfterTreatmentHealtState(String afterTreatmentHealtState) {
        this.afterTreatmentHealtState = afterTreatmentHealtState;
    }
}
