package s22678.Model;

import java.time.LocalDateTime;

public class Bed {
    public String name;
    public Person.Patient patient;

    public Bed() {
        name = "Lozko: " + LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "Bed{" +
                "name='" + name + '\'' +
                '}';
    }
}
