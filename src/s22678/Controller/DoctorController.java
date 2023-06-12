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

    public static Person getDoctorWithSmallestNumberOfPatients() {
        Person smallestDoctor = getDoctorsWithPatients().get(0);  // Assume the first doctor has the smallest number of patients

        for (Person person : getDoctorsWithPatients()) {
            if (person.getDoctorTreatments().size() < smallestDoctor.getDoctorTreatments().size()) {
                smallestDoctor = person;
            }
        }

        return smallestDoctor;
    }
}
