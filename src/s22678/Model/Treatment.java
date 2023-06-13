package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Treatment> extent = new ArrayList<>();
    private PatientCard patientCard;
    private Person doctor;
    private Person patient;
    private List<String> prescribedMedicine = new ArrayList<>();
    private boolean isOperationNeeded;
    private LocalDateTime treatmentStart;
    private LocalDateTime treatmentEnd;
    private String afterTreatmentHealtState;
    private String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Person getPatient() {
        return patient;
    }

    public Person getDoctor() { return doctor;}

    public static void newFile() {
        extent.removeAll(extent);
    }

    public Treatment(Person doctor, Person patient) {
        if (setPerson(doctor, PersonRole.DOCTOR) && setPerson(patient, PersonRole.PATIENT)) {
            treatmentStart = LocalDateTime.now();
            extent.add(this);
        }
    }

    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (List<Treatment>) stream.readObject();
    }

    public static void printExtent() {
        System.out.println(extent);
    }

    public static List<Treatment> getExtent() {
        return extent;
    }

    public PatientCard getPatientCard() {
        return patientCard;
    }

    public void setPatientCard() {
        if(this.patientCard == null) {
            this.patientCard = patient.getPatientCard();
            patientCard.addTreatmentToPatientHistory(this);
        }
    }

    public boolean startTreatment(Person doctor, Person patient) {
        treatmentStart = LocalDateTime.now();
        if (setPerson(doctor, PersonRole.DOCTOR) && setPerson(patient, PersonRole.PATIENT)) {
            return true;
        }

        return false;
    }

    public void finishTreatment() {
        treatmentEnd = LocalDateTime.now();
        setPatientCard();
        patient.setPatientTreatments(null);
        setOperationNeeded(false);
        patient = null;
        doctor.removeDoctorTreatments(this);
        doctor = null;
    }

    public Person getPerson(PersonRole role) {
        if (role == PersonRole.PATIENT) {
            return patient;
        }
        return doctor;
    }

    public boolean setPerson(Person person, PersonRole role) {
        if (person == null) {
            if (role == PersonRole.PATIENT) patient = null;
            if (role == PersonRole.DOCTOR) doctor = null;
            return true;
        }
        if (role == person.getRole()) {
            if (role == PersonRole.PATIENT && patient == null) {
                patient = person;
                if (patient.getPatientTreatment() == null) {
                    patient.setPatientTreatments(this);
                    return true;
                }
            }

            if (role == PersonRole.DOCTOR && doctor == null) {
                doctor = person;
                if (!doctor.getDoctorTreatments().contains(this)) {
                    doctor.addDoctorTreatments(this);
                    return true;
                }
            }
        }
        return false;
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

    public boolean setOperationNeeded(boolean operationNeeded) {
        if (operationNeeded) {
            Bed availableBed = Bed.getAvailableBed();
            if (availableBed == null ) {
                return false;
            }
            patient.setPatientBed(availableBed);
        } else {
            if (patient.getPatientBed() != null) {
                patient.getPatientBed().freeBed();
            }
        }
        isOperationNeeded = operationNeeded;
        return true;
    }

    public LocalDateTime getTreatmentStart() {
        return treatmentStart;
    }

    public void setTreatmentStart(LocalDateTime treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    public LocalDateTime getTreatmentEnd() {
        return treatmentEnd;
    }

    public void setTreatmentEnd(LocalDateTime treatmentEnd) {
        this.treatmentEnd = treatmentEnd;
    }

    public String getAfterTreatmentHealtState() {
        return afterTreatmentHealtState;
    }

    public void setAfterTreatmentHealtState(String afterTreatmentHealtState) {
        this.afterTreatmentHealtState = afterTreatmentHealtState;
    }

    @Override
    public String toString() {
        if (treatmentStart == null && treatmentEnd == null) {
            return "Treatment not started";
        }

        if (treatmentStart != null && treatmentEnd == null) {
            String result = "";
            if (prescribedMedicine.size() > 0) result = ", prescribedMedicine=" + prescribedMedicine;
            return "Treatment{" +
                    ", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() +
                    ", patient=" + patient.getFirstName() + " " + patient.getLastName() +
                    result +
                    ", isOperationNeeded=" + isOperationNeeded +
                    ", treatmentStart=" + treatmentStart +
                    '}';
        }

        if (treatmentStart != null && treatmentEnd != null) {
            return "Treatment over; Treatment start: " + treatmentStart + " Treatment end: " + treatmentEnd + " afterTreatmentHealtState: " + afterTreatmentHealtState;
        }
        return "";
    }
}
