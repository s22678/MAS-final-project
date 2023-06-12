package s22678.Controller;

import s22678.Model.Person;
import s22678.Model.Treatment;

import static s22678.Controller.DoctorController.getDoctorWithSmallestNumberOfPatients;

public class TreatmentController {
    public static void createTreatment(Person patient) {
        new Treatment(getDoctorWithSmallestNumberOfPatients(), patient);
    }
}
