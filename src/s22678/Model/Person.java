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
    private static HashMap<String, Person> extent = new HashMap<>();
    private static int minTrainingsRequired;
    private String firstName;
    private String lastName;
    private String PESEL;
    private String address;
    private Doctor doctor;
    private Patient patient;
    private PersonRole currentRole;

    /**
     * This constructor creates a Person of type Doctor who treats patients. A doctor can become a patient.
     * When doctor is a patient, he can't treat patients. All patients assigned to this doctor end their treatment
     * and must start another treatment (and be assigned to a new doctor)
     * @param PESEL
     * @param firstName
     * @param lastName
     * @param address
     * @param salary
     * @param specialization
     * @param doctorFields
     */
    public Person(String PESEL, String firstName, String lastName, String address, int salary, String specialization, DoctorField... doctorFields) {
        if(addDoctorRoleToPerson(salary, specialization, doctorFields)) {
            this.PESEL = PESEL;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            extent.put(PESEL, this);
        }
    }

    /**
     * This constructor creates a Person of type Patient. A patient must not be treated to be considered a doctor
     * in this system.
     * @param PESEL
     * @param firstName
     * @param lastName
     * @param address
     * @param bloodType
     * @param allergies
     * @param isContagious
     * @param patientCard
     */
    public Person(String PESEL, String firstName, String lastName, String address, String bloodType, String allergies, boolean isContagious, PatientCard patientCard) {
        if(addPatientRoleToPerson(bloodType, allergies, isContagious, patientCard)) {
            this.PESEL = PESEL;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            extent.put(PESEL, this);
        }
    }

    /**
     * If a person has a patient only, this method allows to add a doctor attributes and make patient a doctor.
     * @param salary
     * @param specialization
     * @param doctorFields
     * @return
     */
    public boolean addDoctorRoleToPerson(int salary, String specialization, DoctorField... doctorFields) {
        if (this.doctor == null) {
            this.doctor = new Doctor(salary, specialization, doctorFields);
            currentRole = PersonRole.DOCTOR;
            return true;
        }
        return false;
    }

    /**
     * If a person has a doctor role only, this method allows to add a patient's attributes and make doctor a patient.
     * @param bloodType
     * @param allergies
     * @param isContagious
     * @param patientCard
     * @return
     */
    public boolean addPatientRoleToPerson(String bloodType, String allergies, boolean isContagious, PatientCard patientCard) {
        if (this.patient == null) {
            currentRole = PersonRole.PATIENT;
            this.patient = new Patient(bloodType, allergies, isContagious);
            this.patient.setPatientCard(patientCard);
            return true;
        }
        return false;
    }

    /**
     * Remove all Person objects from the extent.
     */
    public static void newFile() {
        extent.clear();
    }

    /**
     * Save the Person objects from the extent to the save file.
     * @param stream stream of data for a save file.
     * @throws IOException
     */
    public static void save(ObjectOutputStream stream) throws IOException {
        stream.writeObject(minTrainingsRequired);
        stream.writeObject(extent);
    }

    /**
     * Load data from file and save it in the Person extent.
     * @param stream stream of data from the save file.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void load(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        minTrainingsRequired = (int) stream.readObject();
        extent = (HashMap<String, Person>) stream.readObject();
    }

    /**
     * Simple getter for Person extent
     * @return List of all Person objects created so far, saved in an extent.
     */
    public static HashMap<String, Person> getExtent() {
        return extent;
    }

    /**
     * Remove a Person from the extent. This allows to remove unwanted patients or doctors removed from the system.
     * @param PESEL of the person that needs to be removed from the system.
     */
    public void removeFromExtent(int PESEL) {
        extent.remove(PESEL);
    }

    /**
     * When adding a new patient it's good to check if some fields were left empty. If so - return false to indicate
     * that few TextFields are empty and need to be filled out.
     * @param textFields list of TextFields with the patient's information.
     * @return whether the information in TextFields is too short (less than 2 characters).
     */
    public static boolean isTextFieldDataIncorrect(String... textFields) {
        for(String field : textFields) {
            if (field.length() < 2) {
                System.out.println("Bad input data: " + field.length());
                return true;
            }
        }
        return false;
    }

    /**
     * Get a Person object from the extent given his pesel, first and last name.
     * @param PESEL person's pesel.
     * @param firstName person's first name.
     * @param lastName person's last name.
     * @return person
     */
    public static Person getPersonByFullNameandPesel(String PESEL, String firstName, String lastName) {
        for (Person person : extent.values()) {
            if (person.PESEL == PESEL && person.firstName.equals(firstName) && person.lastName.equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    /**
     * Change minimum amount of trainings completed required for all doctors.
     * @param newMin new amount of minimum trainings.
     */
    public static void changeMinTrainingsRequired(int newMin) {
        minTrainingsRequired = newMin;
    }

    /**
     * Get the minimum amount of trainings that must be completed by all doctors.
     * @return minimum number of trainings.
     */
    public int getMinTrainingsRequired() {
        return minTrainingsRequired;
    }

    /**
     * Get the Person's first name.
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the Person's last name.
     * @return last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the Person's pesel.
     * @return pesesl.
     */
    public String getPESEL() {
        return PESEL;
    }

    /**
     * Get the person's address
     * @return address as a String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the doctor 'subclass' of the Person.
     * @return Doctor object
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Get the patient 'subclass' of the Person.
     * @return Patient object
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Get birthday of the Person object.
     * @return birthday as a String type.
     */
    public String getBirthday() {
        String birthday = getPESEL();
        if (Character.getNumericValue(birthday.charAt(2)) > 1) {
            int intMonth = Character.getNumericValue(birthday.charAt(2)) - 2;
            String strMonth = String.valueOf(intMonth);
            return "20" + birthday.substring(0, 2) + strMonth + birthday.substring(3, 6);
        } else {
            return "19" + PESEL.substring(0, 6);
        }
    }

    /**
     * Get birthday of the Person Subject.
     * @return birthday as a LocalDate type.
     */
    public LocalDate getBirthdayDate() {
        String birthday = getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(birthday, formatter);
    }

    /**
     * Get age of the Person object.
     * @return age as an integer.
     */
    public int getAge() {
        return Period.between(getBirthdayDate(), LocalDate.now()).getYears();
    }

    /**
     * This method aggregates pesel, first, last name, admission date and optionally a patient's doctor if the patient
     * is being treated. This allows to read the patient's data in the JTable.
     * @return Array consisting of patient's personal data.
     */
    public String[] getPatientTableData() {
        if (patient.getTreatment() == null) {
            return new String[]{getPESEL(), getFirstName(), getLastName(), getPatientAdmissionDate().toString().substring(0, 16), ""};
        }
        return new String[]{getPESEL(), getFirstName(), getLastName(), getPatientAdmissionDate().toString().substring(0, 16), patient.getTreatment().getTreatingDoctor()};
    }

    /**
     * This method aggregates pesel, first, last name, and doctor's specialization.
     * This allows to read the doctor's data in the JTable.
     * @return Array consisting of doctor's personal data.
     */
    public String[] getDoctorTableData() {
        String[] data = {getPESEL(), getFirstName(), getLastName(), getDoctorSpecialization()};
        return data;
    }

    /**
     * Get current role that's assigned to the Person - either a Doctor or a Patient.
     * @return Person's role.
     */
    public PersonRole getCurrentRole() {
        return currentRole;
    }

    /**
     * Change the role of the Person from Doctor to Patient and vice versa.
     * @return bool whether the change was successful or not.
     */
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

    /**
     * Get Doctor's specialization
     * @return specialization, or 'not a doctor' information when Person is not a Doctor.
     */
    public String getDoctorSpecialization() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getSpecialization();
        }
        return "not a doctor";
    }

    /**
     * Set Doctor's salary if the Person is a Doctor.
     * @param salary new Doctor's salary.
     */
    public void setDoctorSalary(int salary) {
        if (currentRole == PersonRole.DOCTOR) {
            doctor.setSalary(salary);
        }
    }

    /**
     * If the Person is a Doctor, get his salary
     * @return salary or 0 if the person is not a Doctor.
     */
    public int getDoctorSalary() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getSalary();
        }
        return 0;
    }

    /**
     * If the Person is a Doctor, get successful operations.
     * @return list with successful operations
     */
    public List<String> getDoctorSuccessfulOperations() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getSuccessfulOperations();
        }
        return null;
    }

    /**
     * Get the fields of the Doctor. Possible values are SURGEON or DIAGNOSTICIAN.
     * @return field of the Doctor
     */
    public EnumSet<DoctorField> getDoctorFields() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getFields();
        }
        return null;
    }

    /**
     * Get all the Treatments the Doctor is involved in.
     * @return list of Treatments.
     */
    public List<Treatment> getDoctorTreatments() {
        if (currentRole == PersonRole.DOCTOR) {
            return doctor.getTreatments();
        }
        return null;
    }

    /**
     * Add new Treatment to the Doctor's queue.
     * @param treatment new Treatment.
     */
    public void addDoctorTreatments(Treatment treatment) {
        if (currentRole == PersonRole.DOCTOR) {
            doctor.addTreatment(treatment);
        }
    }

    /**
     * If the Treatment is over - remove the Treatment from the Doctor's queue.
     * @param treatment that is to be removed from the Treatments list.
     */
    public void removeDoctorTreatments(Treatment treatment) {
        if (currentRole == PersonRole.DOCTOR) {
            doctor.removeTreatment(treatment);
        }
    }

    /**
     * Set the Bed where Patient is being treated. Creates a double association.
     * @param bed which will be assigned to Patient.
     */
    public void setPatientBed(Bed bed)  {
        if (currentRole == PersonRole.PATIENT) {
            patient.bed = bed;
        }

        if (bed != null) {
            bed.setPatient(this);
        }
    }

    /**
     * Get the Bed that is assigned to the Patient.
     * @return Bed object.
     */
    public Bed getPatientBed() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getBed();
        }
        return null;
    }

    /**
     * Return Patient's parents information (names and last name).
     * @return Patient's parents' names.
     */
    public String getPatientParentsInfo() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getParentsInfo();
        }
        return "";
    }

    /**
     * Set the Patient's parents information.
     * @param parentsInfo 
     */
    public void setPatientParentsInfo(String parentsInfo) {
        if (currentRole == PersonRole.PATIENT) {
            patient.setParentsInfo(parentsInfo);
        }
    }

    public String getPatientParentsContactInfo() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getParentsContactInfo();
        }
        return "";
    }

    public void setPatientParentsContactInfo(String parentsContactInfo) {
        if (currentRole == PersonRole.PATIENT) {
            patient.setParentsContactInfo(parentsContactInfo);
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

    public boolean isPatientContagious() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.isContagious();
        }
        return false;
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

    public String getPatientAllergies() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.getAllergies();
        }
        return "";
    }

    public boolean isPatientAdult() {
        if (currentRole == PersonRole.PATIENT) {
            return patient.isAdult();
        }
        return true;
    }

    public LocalDateTime getPatientAdmissionDate() {
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
            this.specialization = specialization;
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

        private void setSalary(int salary) {
            this.salary = salary;
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
        private boolean isContagious;
        private String parentsInfo;
        private String parentsContactInfo;
        private String allergies;

        private String getAllergies() {
            return allergies;
        }

        private String getParentsInfo() {
            return parentsInfo;
        }

        private void setParentsInfo(String parentsInfo) {
            this.parentsInfo = parentsInfo;
        }

        private String getParentsContactInfo() {
            return parentsContactInfo;
        }

        private void setParentsContactInfo(String parentsContactInfo) {
            this.parentsContactInfo = parentsContactInfo;
        }

        private boolean isContagious() {
            return isContagious;
        }

        private Bed getBed() {
            return bed;
        }

        private boolean isAdult() {
            return Person.this.getAge() >= 18;
        }

        private LocalDateTime getAdmissionDate() {
            return admissionDate;
        }

        private String getBloodType() {
            return bloodType;
        }

        private Patient(String bloodType, String allergies, boolean isContagious) {
            this.admissionDate = LocalDateTime.now();
            this.bloodType = bloodType;
            this.allergies = allergies;
            this.isContagious = isContagious;
            System.out.println("creating new patient with allergies: " + allergies);
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
                    "allergies='" + allergies + '\'' +
                    '}';
        }
    }
}
