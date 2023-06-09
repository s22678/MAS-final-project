import s22678.Controller.PersonController;
import s22678.Model.Bed;
import s22678.Model.Person;
import s22678.View.PersonView;

public class Main {
    public static void main(String[] args) {
        PersonView view = new PersonView();
        PersonController controller = new PersonController(view);
//        final Person person1 = new Person(432, "Kajtek", 433);
//        System.out.println(person1);
//
//        person1.addPatientRoleToPerson("A+");
//        System.out.println(person1);
//        try {
//            person1.setPatientBed(new Bed());
//            System.out.println(person1);
//        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
//        }
//        person1.switchRole();
//        System.out.println(person1);
//
//        person1.switchRole();
//        System.out.println(person1);
    }
}
