import s22678.Model.*;
import s22678.View.Main.MainView;
import s22678.Controller.MainController;

import javax.swing.*;
import java.util.List;

public class Main {
    private final static boolean save = false;
    private final static boolean load = false;
    private final static String fileDir = ".\\save";

    private final static String mydir = System.getProperty("user.dir");
    public static void main(String[] args) {
        System.out.println(mydir);
//        setup(save);
        SwingUtilities.invokeLater(() -> {
            MainView menu = new MainView();
            menu.setVisible(true);
        });
    }

    public static void setup(boolean save) {
        if (save) {
            // Add rooms
            final Room room1 = new Room(1);
//            final Room room2 = new Room(2);

            final Bed bed1 = new Bed();
            final Bed bed2 = new Bed();
//            final Bed bed3 = new Bed();
//            final Bed bed4 = new Bed();
//            final Bed bed5 = new Bed();
//            final Bed bed6 = new Bed();

            room1.addBed(bed1);
            room1.addBed(bed2);
//            room1.addBed(bed3);
//            room2.addBed(bed4);
//            room2.addBed(bed5);
//            room2.addBed(bed6);

            final Person doctor1 = new Person("23223", "Jan", "Kowalski", "Ziemowita 5", 3000, "ortopeda", DoctorField.SURGEON);

            final Person doctor2 = new Person("763353", "Radosław", "Szymczak", "Gdańska 3", 5000, "internista", DoctorField.DIAGNOSTICIAN);
            doctor2.addPatientRoleToPerson("0-", false);
            System.out.println(doctor2);

            PatientCard patientCard1 = new PatientCard();
            final Person patient1 = new Person("43343", "Kornel", "Sikora", "Klonowa 7", "A+", false, patientCard1);
            PatientCard patientCard2 = new PatientCard();
            final Person patient2 = new Person("5663", "Kordian", "Kołodziej", "Lipowa 12", "A+",false, patientCard2);
            PatientCard patientCard3 = new PatientCard();
            final Person patient3 = new Person("82572", "Piotr", "Wiśniewski", "Słoneczna 22", "A+", false, patientCard3);
            PatientCard patientCard4 = new PatientCard();
            final Person patient4 = new Person("82562", "Miron", "Mazurek", "Polna 15", "A+", false, patientCard4);
            PatientCard patientCard5 = new PatientCard();
            final Person patient5 = new Person("86256565", "Bronisław", "Błaszczyk", "Akacjowa 9", "B+", false, patientCard5);
            PatientCard patientCard6 = new PatientCard();
            final Person patient6 = new Person("2569425", "Alex", "Adamska", "Topolowa 4", "B+", false, patientCard6);
            PatientCard patientCard7 = new PatientCard();
            final Person patient7 = new Person("624725773", "Jarosław", "Zieliński", "Dębowa 17", "B+", false, patientCard7);
            PatientCard patientCard8 = new PatientCard();
            final Person patient8 = new Person("43736373", "Krzysztof", "Zalewski", "Brzozowa 3", "B+", false, patientCard8);
            PatientCard patientCard9 = new PatientCard();
            final Person patient9 = new Person("6373673", "Roman", "Lis", "Wąska 11", "B+", false, patientCard9);
            PatientCard patientCard10 = new PatientCard();
            final Person patient10 = new Person("663732", "Kacper", "Makowski", "Jesienna 8", "B+", false, patientCard10);

            Treatment treatment1 = new Treatment(doctor1, patient1);
            Treatment treatment2 = new Treatment(doctor2, patient2);
            Treatment treatment3 = new Treatment(doctor1, patient3);
//            Treatment treatment4 = new Treatment(doctor1, patient4);
//            Treatment treatment5 = new Treatment(doctor1, patient5);
//            Treatment treatment6 = new Treatment(doctor1, patient6);
//            Treatment treatment7 = new Treatment(doctor1, patient7);
//            Treatment treatment8 = new Treatment(doctor1, patient8);
//            Treatment treatment9 = new Treatment(doctor1, patient9);
//            Treatment treatment10 = new Treatment(doctor1, patient10);

            System.out.println(treatment1);
            treatment1.setOperationNeeded(true);
            treatment3.setOperationNeeded(true);
            System.out.println(patient1);
            System.out.println(doctor1);
            if (treatment2.getTreatmentStart() != null) {
                treatment2.finishTreatment();
            }
            treatment1.finishTreatment();
            System.out.println(patient1.getPatientCard());

            System.out.println("Zapis instancji...");
//            MainController.save(fileDir + "\\File.dat");
        }

        if (load){
//            MainController.load(fileDir + "\\File.dat");

            System.out.println("łóżka");
            List<Bed> beds = Bed.getExtent();
            System.out.println(beds);
            System.out.println("karty pacjenta");
            PatientCard.printExtent();
            System.out.println("osoby");
            Person.printExtent();
            System.out.println("pokoje");
            Room.printExtent();
            System.out.println("leczenia");
            List<Treatment> treatments = Treatment.getExtent();
            System.out.println(treatments);
            System.out.println("koniec");
        }
    }
}