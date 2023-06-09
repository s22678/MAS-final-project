package s22678.Model;

import java.util.*;

public class Person {
    private static HashMap<Integer, Person> personExtent = new HashMap<>();
    public static Person getPersonByFullName(String firstName, String lastName) {
        for (Person person : personExtent.values()) {
            if (person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null; // If not found
    }

    public static Person getPersonByFullNameandPesel(Integer Pesel, String firstName, String lastName) {
        for (Person person : personExtent.values()) {
            if (person.PESEL == Pesel && person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    private static int minTrainingsRequired;
    String firstName;
    String lastName;
    int PESEL;
    private Doctor doctor;
    private Patient patient;
    private PersonRole currentRole;

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
    public Person(int PESEL, String firstName, int idDoctor) {
        if(addDoctorRoleToPerson(idDoctor)) {
            this.firstName = firstName;
            this.PESEL = PESEL;
            personExtent.put(PESEL, this);
        }
    }

    // Add Patient
    public Person(int PESEL, String firstName, String bloodType) {
        if(addPatientRoleToPerson(bloodType)) {
            this.firstName = firstName;
            this.PESEL = PESEL;
            personExtent.put(PESEL, this);
        }
    }

    public boolean addDoctorRoleToPerson(int idDoctor) {
        if (this.doctor == null) {
            this.doctor = new Doctor(idDoctor);
            currentRole = PersonRole.DOCTOR;
            return true;
        }
        return false;
    }

    public boolean addPatientRoleToPerson(String bloodType) {
        if (this.patient == null) {
            this.patient = new Patient(bloodType);
            currentRole = PersonRole.PATIENT;
            return true;
        }
        return false;
    }

    public Bed getPatientBed() throws WrongRoleException {
        if (currentRole == PersonRole.PATIENT) {
            return patient.bed;
        } else {
            throw new WrongRoleException("Person is not a patient");
        }
    }

    public void setPatientBed(Bed bed) throws WrongRoleException {
        if (currentRole == PersonRole.PATIENT) {
            patient.bed = bed;
        } else {
            throw new WrongRoleException("Person is not a patient");
        }
    }

    public void addDoctorTreatment(Treatment treatment) {
        doctor.addTreatment(treatment);
    }

    public List<Treatment> getDoctorTreatments() {
        return doctor.getTreatments();
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

    public List<Treatment> getDoctorsTreatments() {
        return doctor.getTreatments();
    }

    public void setDoctorsTreatments(Treatment treatment) {
        doctor.addTreatment(treatment);
    }

    @Override
    public String toString() {
        String output = "Person{" +
                "name='" + firstName + '\'' +
                ", PESEL=" + PESEL +
                ", currentRole=" + currentRole;

        if (currentRole == PersonRole.PATIENT) {
                    return output +
                    ", Bed=" + patient.bed +
                    '}';
        }

        return output + '}';
    }

    class Doctor {
        private int pensja;
        private String specialization;
        private EnumSet<DoctorField> fields;
        private List<Treatment> treatments = new ArrayList<>();
        private List<String> trainings = new ArrayList<>();

        private Doctor(int pensja, String specialization, DoctorField... doctorFields) {
            this.pensja = pensja;
            fields = EnumSet.noneOf(DoctorField.class);
            for (DoctorField field : doctorFields) {
                fields.add(field);
            }
        }

        private int getPensja() {
            return pensja;
        }

        private void setPensja(int id) {
            this.pensja = id;
        }

        private List<Treatment> getTreatments() {
            return treatments;
        }

        public void addTreatment(Treatment treatment) {
            if(!treatments.contains(treatment)) {
                treatments.add(treatment);
            }

            if (treatment.getPerson(PersonRole.DOCTOR) == null){
                treatment.setDoctor(Person.this.getFirstName(), Person.this.getLastName());
            }
        }

        public List<String> getTrainings() {
            return trainings;
        }

        public void setTrainings(String... trainings) {
            this.trainings = Arrays.asList(trainings);
        }

        class Surgeon {
            private List<String> successfulOperations = new ArrayList<>();

            private Surgeon() {}

            private List<String> getSuccessfulOperations() {
                return successfulOperations;
            }

            private void setSuccessfulOperations(List<String> successfulOperations) {
                this.successfulOperations = successfulOperations;
            }
        }

        class Diagnostician {
            private Diagnostician() {}
        }
    }

    class Patient {
        private String bloodType;
        private Treatment treatment;
        private Bed bed;

        private Patient(String bloodType) {
            this.bloodType = bloodType;
        }

        private Treatment getTreatment() {
            return treatment;
        }

        private void addTreatment(Treatment treatment) {
            if(this.treatment == null) {
                this.treatment = treatment;
            }

            if (treatment.getPerson(PersonRole.PATIENT) == null){
                treatment.setPatient(Person.this.getPESEL(), Person.this.getFirstName(), Person.this.getLastName());
            }
        }
    }
}
