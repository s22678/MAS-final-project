package s22678.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private static HashMap<Integer, Person> personExtent = new HashMap<>();
    private static int minTrainingsRequired;
    private String firstName;
    private String lastName;
    private int PESEL;
    private String address;
    private Doctor doctor;
    private Patient patient;
    private PersonRole currentRole;

    public static void savePersons(ObjectOutputStream stream) throws IOException {
        try {
            stream.writeObject(minTrainingsRequired);
            stream.writeObject(personExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPersons(ObjectInputStream stream) throws IOException {
        try {
            minTrainingsRequired = (int) stream.readObject();
            personExtent = (HashMap<Integer, Person>) stream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Person getPersonByFullName(String firstName, String lastName) {
        for (Person person : personExtent.values()) {
            if (person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public static Person getPersonByFullNameandPesel(Integer Pesel, String firstName, String lastName) {
        for (Person person : personExtent.values()) {
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

    public static void printPersonExtent() {
        for (Integer PESEL : personExtent.keySet()) {
            System.out.println("PESEL: " + PESEL + " Osoba: " + personExtent.get(PESEL));
        }
    }

    public void removeFromExtent(int PESEL) {
        if (personExtent.containsKey(PESEL)) {
            personExtent.remove(PESEL);
        }
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
            personExtent.put(PESEL, this);
        }
    }

    // Add Patient
    public Person(int PESEL, String firstName, String lastName, String address, String bloodType, PatientCard patientCard) {
        if(addPatientRoleToPerson(bloodType, patientCard)) {
            this.PESEL = PESEL;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            personExtent.put(PESEL, this);
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

    public boolean addPatientRoleToPerson(String bloodType, PatientCard patientCard) {
        if (this.patient == null) {
            this.patient = new Patient(bloodType, patientCard);
            currentRole = PersonRole.PATIENT;
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

    public String getRole() {
        return currentRole.toString();
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

    private String getPatientBloodType() {
        return patient.getBloodType();
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

    class Doctor {
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

        public String getSpecialization() {
            return specialization;
        }

        public EnumSet<DoctorField> getFields() {
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
            if (treatment.getPerson(PersonRole.DOCTOR) != null){
                treatment.setPerson(null, PersonRole.DOCTOR);
            }

            if(!treatments.contains(treatment)) {
                treatments.remove(treatment);
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

    class Patient {
        private String bloodType;
        private Treatment treatment;
        private Bed bed;
        private PatientCard patientCard;
        private LocalDate admissionDate;

        private boolean isAdult() {
            return Person.this.getAge() >= 18;
        }

        private String getBloodType() {
            return bloodType;
        }

        private Patient(String bloodType, PatientCard patientCard) {
            this.admissionDate = LocalDate.now();
            this.bloodType = bloodType;
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
