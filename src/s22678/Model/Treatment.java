package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Treatment implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Treatment> treatmentExtent = new ArrayList<>();
    private PatientCard patientCard;
    private Person doctor;
    private Person patient;
    private List<String> prescribedMedicine = new ArrayList<>();
    private boolean isOperationNeeded;
    private LocalDate treatmentStart;
    private LocalDate treatmentEnd;
    private String afterTreatmentHealtState;

    public Treatment() {
        treatmentExtent.add(this);
    }

    public static void saveTreatments(ObjectOutputStream stream) throws IOException {
        try {
            stream.writeObject(treatmentExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTreatments(ObjectInputStream stream) throws IOException {
        try {
            treatmentExtent = (List<Treatment>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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

    public void startTreatment(Person doctor, Person patient) {
        treatmentStart = LocalDate.now();
        setPerson(doctor, PersonRole.DOCTOR);
        setPerson(patient, PersonRole.PATIENT);
    }

    public void finishTreatment() {
        treatmentEnd = LocalDate.now();
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

    public void setPerson(Person person, PersonRole role) {
        if (patient == null && role == PersonRole.PATIENT) {
            patient = person;
            if (patient.getPatientTreatment() == null) {
                patient.setPatientTreatments(this);
            }
        }

        if (doctor == null && role == PersonRole.DOCTOR) {
            doctor = person;
            if (!doctor.getDoctorTreatments().contains(this)) {
                doctor.addDoctorTreatments(this);
            }
        }
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
        if (operationNeeded) {
            Bed availableBed = Bed.getAvailableBed();
            patient.setPatientBed(availableBed);
        } else {
            patient.getPatientBed().freeBed();
        }
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

    @Override
    public String toString() {
        return "Treatment{" +
                ", doctor=" + doctor.getFirstName() + " " + doctor.getLastName() +
                ", patient=" + patient.getFirstName() + " " + patient.getLastName() +
//                ", prescribedMedicine=" + prescribedMedicine +
//                ", isOperationNeeded=" + isOperationNeeded +
//                ", treatmentStart=" + treatmentStart +
//                ", treatmentEnd=" + treatmentEnd +
//                ", afterTreatmentHealtState='" + afterTreatmentHealtState + '\'' +
                '}';
    }
}
