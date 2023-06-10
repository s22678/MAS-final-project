package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private static HashMap<Integer, Person> extent = new HashMap<>();
    private static int minTrainingsRequired;
    private String firstName;
    private String lastName;
    private int PESEL;
    private String address;
    private Doctor doctor;
    private Patient patient;
    private PersonRole currentRole;

    public static void save(ObjectOutputStream stream) throws IOException {
        try {
            stream.writeObject(minTrainingsRequired);
            stream.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getTableData() {
        String[] data = {getFirstName(), getLastName(), getAdmissionDate().toString()};
        return data;
    }

    public static void load(ObjectInputStream stream) throws IOException {
        try {
            minTrainingsRequired = (int) stream.readObject();
            extent = (HashMap<Integer, Person>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, Person> getExtent() {
        return extent;
    }

    public static Person getPersonByFullName(String firstName, String lastName) {
        for (Person person : extent.values()) {
            if (person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public static Person getPersonByFullNameandPesel(Integer Pesel, String firstName, String lastName) {
        for (Person person : extent.values()) {
            if (person.PESEL == Pesel && person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public LocalDate getBirthDay() {
        String peselString = Integer.toString(getPESEL());
        String birthDay = peselString.substring(0, 6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        return LocalDate.parse(birthDay, formatter);
    }

    public int getAge() {
        return Period.between(getBirthDay(), LocalDate.now()).getYears();
    }

    public static void changeMinTrainingsRequired(int newMin) {
        minTrainingsRequired = newMin;
    }

    public int getMinTrainingsRequired() {
        return minTrainingsRequired;
    }

    public static void printExtent() {
        for (Integer PESEL : extent.keySet()) {
            System.out.println("PESEL: " + PESEL + " Osoba: " + extent.get(PESEL));
        }
    }

    public void removeFromExtent(int PESEL) {
        extent.remove(PESEL);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPESEL() {
        return PESEL;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public PersonRole getCurrentRole() {
        return currentRole;
    }

    // Add doctor
    public Person(int PESEL, String firstName, String lastName, String address, int salary, String specialization, DoctorField... doctorFields) {
        if(addDoctorRoleToPerson(salary, specialization, doctorFields)) {
            this.PESEL = PESEL;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            extent.put(PESEL, this);
        }
    }

    // Add Patient
    public Person(int PESEL, String firstName, String lastName, String address, String bloodType, PatientCard patientCard) {
        if(addPatientRoleToPerson(bloodType, patientCard)) {
            this.PESEL = PESEL;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            extent.put(PESEL, this);
        }
    }

    public boolean addDoctorRoleToPerson(int salary, String specialization, DoctorField... doctorFields) {
        if (this.doctor == null) {
            this.doctor = new Doctor(salary, specialization, doctorFields);
            currentRole = PersonRole.DOCTOR;
            return true;
        }
        return false;
    }

    public boolean addPatientRoleToPerson(String bloodType) {
        if (this.patient == null) {
            currentRole = PersonRole.PATIENT;
            PatientCard patientCard = new PatientCard();
            this.patient = new Patient(bloodType);
            this.patient.setPatientCard(patientCard);
            return true;
        }
        return false;
    }

    public boolean addPatientRoleToPerson(String bloodType, PatientCard patientCard) {
        if (this.patient == null) {
            currentRole = PersonRole.PATIENT;
            this.patient = new Patient(bloodType);
            this.patient.setPatientCard(patientCard);
            return true;
        }
        return false;
    }

    public Bed getPatientBed() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.bed;
        }
        return null;
    }

    private String getDoctorSpecialization() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getSpecialization();
        }
        return "";
    }

    private EnumSet<DoctorField> getFields() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getFields();
        }
        return null;
    }

    public void setPatientBed(Bed bed)  {
        if (currentRole == PersonRole.PATIENT) {
            patient.bed = bed;
        }

        if (bed != null) {
            bed.setPatient(this);
        }
    }

    public boolean switchRole() {
        if (currentRole == PersonRole.PATIENT && doctor != null) {
            currentRole = PersonRole.DOCTOR;
            return true;
        }

        if (currentRole == PersonRole.DOCTOR && patient != null ){
            currentRole = PersonRole.PATIENT;
            return true;
        }

        return false;
    }

    public PersonRole getRole() {
        return currentRole;
    }

    public List<Treatment> getDoctorTreatments() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getTreatments();
        }
        return null;
    }

    public void addDoctorTreatments(Treatment treatment) {
        if (currentRole == PersonRole.DOCTOR) {
            doctor.addTreatment(treatment);
        }
    }

    public void removeDoctorTreatments(Treatment treatment) {
        if (currentRole == PersonRole.DOCTOR) {
            doctor.removeTreatment(treatment);
        }
    }

    public void setPatientTreatments(Treatment treatment) {
        if (currentRole == PersonRole.PATIENT) {
            patient.setTreatment(treatment);
        }
    }

    public Treatment getPatientTreatment() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getTreatment();
        }
        return null;
    }

    public PatientCard getPatientCard() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getPatientCard();
        }
        return null;
    }

    public void setPatientCard(PatientCard patientCard) {
        if (patient.getPatientCard() == null && currentRole == PersonRole.PATIENT) {
            patient.patientCard = patientCard;
        }

        if (patientCard.getPatient() == null) {
            patientCard.setPatient(Person.this);
        }
    }

    public String getPatientBloodType() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getBloodType();
        }
        return null;
    }

    public LocalDateTime getAdmissionDate() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getAdmissionDate();
        }
        return null;
    }

    @Override
    public String toString() {
        if (currentRole == PersonRole.PATIENT) {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", patient=" + patient +
                    ", currentRole=" + currentRole +
                    '}';
        }
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", doctor=" + doctor +
                ", currentRole=" + currentRole +
                '}';
    }

    class Doctor implements Serializable {
        private int salary;
        private String specialization;
        private EnumSet<DoctorField> fields;
        private List<Treatment> treatments = new ArrayList<>();
        private List<String> trainings = new ArrayList<>();
        private List<String> successfulOperations = new ArrayList<>();

        private Doctor(int salary, String specialization, DoctorField... doctorFields) {
            this.salary = salary;
            fields = EnumSet.noneOf(DoctorField.class);
            for (DoctorField field : doctorFields) {
                fields.add(field);
            }
        }

        private String getSpecialization() {
            return specialization;
        }

        private EnumSet<DoctorField> getFields() {
            return fields;
        }

        private int getSalary() {
            return salary;
        }

        private void setSalary(int id) {
            this.salary = id;
        }

        private List<Treatment> getTreatments() {
            return treatments;
        }

        public void addTreatment(Treatment treatment) {
            if(!treatments.contains(treatment)) {
                treatments.add(treatment);
            }

            if (treatment.getPerson(PersonRole.DOCTOR) == null){
                treatment.setPerson(Person.this, PersonRole.DOCTOR);
            }
        }

        public void removeTreatment(Treatment treatment) {
            if(treatments.contains(treatment)) {
                treatments.remove(treatment);
            }

            if (treatment.getPerson(PersonRole.DOCTOR) != null){
                treatment.setPerson(null, PersonRole.DOCTOR);
            }
        }

        public List<String> getTrainings() {
            return trainings;
        }

        public void setTrainings(String... trainings) {
            this.trainings = Arrays.asList(trainings);
        }

        private List<String> getSuccessfulOperations() {
            if (fields.contains(DoctorField.SURGEON)) {
                return successfulOperations;
            }
            return null;
        }

        private void addSuccessfulOperation(String operation) {
            if (fields.contains(DoctorField.SURGEON)) {
                this.successfulOperations.add(operation);
            }
        }

        @Override
        public String toString() {
            return "Doctor{" +
                    "salary=" + salary +
                    ", specialization='" + specialization + '\'' +
                    ", fields=" + fields +
                    '}';
        }
    }

    class Patient implements Serializable {
        private String bloodType;
        private Treatment treatment;
        private Bed bed;
        private PatientCard patientCard;
        private LocalDateTime admissionDate;

        private boolean isAdult() {
            return Person.this.getAge() >= 18;
        }

        private LocalDateTime getAdmissionDate() {
            return admissionDate;
        }

        private String getBloodType() {
            return bloodType;
        }

        private Patient(String bloodType) {
            this.admissionDate = LocalDateTime.now();
            this.bloodType = bloodType;
        }

        private void setPatientCard(PatientCard patientCard) {
            if (this.patientCard == null) {
                this.patientCard = patientCard;
            }

            if (patientCard.getPatient() == null) {
                patientCard.setPatient(Person.this);
            }
        }

        private PatientCard getPatientCard() {
            return this.patientCard;
        }

        private void setBed(Bed bed) {
            if (this.bed == null || bed == null && this.bed != null) {
                this.bed = bed;
            }

            if (bed.getPatient() == null) {
                bed.setPatient(Person.this);
            }
        }

        private Treatment getTreatment() {
            return treatment;
        }

        private void setTreatment(Treatment treatment) {
            if(this.treatment == null) {
                this.treatment = treatment;
            }

            if (treatment == null && this.treatment != null) {
                this.treatment = null;
                return;
            }

            if (treatment.getPerson(PersonRole.PATIENT) == null){
                treatment.setPerson(Person.this, PersonRole.PATIENT);
            }
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "bloodType='" + bloodType + '\'' +
                    '}';
        }
    }
}
