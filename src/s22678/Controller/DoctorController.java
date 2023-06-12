package s22678.Controller;

import s22678.Model.Person;
import s22678.Model.PersonRole;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorController {
    public static List<Person> getDoctorsWithPatients() {
        List<Person> doctors = new ArrayList<>();
        for (Person doctor : Person.getExtent().values()) {
            if (doctor.getRole() == PersonRole.DOCTOR && doctor.getDoctorTreatments().size() > 0) doctors.add(doctor);
        }
        return doctors;
    }

    public static List<Person> getDoctors() {
        List<Person> doctors = new ArrayList<>();
        for (Person doctor : Person.getExtent().values()) {
            if (doctor.getRole() == PersonRole.DOCTOR) doctors.add(doctor);
        }
        return doctors;
    }

    public static Person getDoctorWithSmallestNumberOfPatients() {
        if (getDoctors().size() == 0) {
            return null;
        }
        
        // Assume first doctor has the lowest number of patients
        Person smallestDoctor = getDoctors().get(0);

        for (Person person : getDoctorsWithPatients()) {
            if (person.getDoctorTreatments().size() < smallestDoctor.getDoctorTreatments().size()) {
                smallestDoctor = person;
            }
        }

        return smallestDoctor;
    }

    public static Person getDoctorByPesel(String PESEL) {
        for (Person doctor : Person.getExtent().values()) {
            if (doctor.getRole() == PersonRole.DOCTOR && doctor.getPESEL().equals(PESEL)) return doctor;
        }
        return null;
    }
}
