package s22678.Controller;

import s22678.Model.Person;

public class PatientController {
    public static Person getPatientByPesel(String PESEL) {
        for(Person person : Person.getExtent().values()) {
            if (person.getPESEL().equals(PESEL)) return person;
        }
        return null;
    }
}
