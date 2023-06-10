import s22678.Model.*;

public class Main {
    public static void main(String[] args) {
        // Add rooms
        final Room room1 = new Room(1);
        final Room room2 = new Room(2);

        final Bed bed1 = new Bed();
        final Bed bed2 = new Bed();
        final Bed bed3 = new Bed();
        final Bed bed4 = new Bed();
        final Bed bed5 = new Bed();
        final Bed bed6 = new Bed();

        room1.addBed(bed1);
        room1.addBed(bed2);
        room1.addBed(bed3);
        room2.addBed(bed4);
        room2.addBed(bed5);
        room2.addBed(bed6);

        Person doctor1 = new Person(23223, "Jan", "Kowalski", "Ziemowita 5", 3000, "ortopeda", DoctorField.SURGEON);

        PatientCard patientCard1 = new PatientCard();
        Person patient1 = new Person(43343, "Kornel", "Sikora", "Klonowa 7", "A+", patientCard1);
        PatientCard patientCard2 = new PatientCard();
        Person patient2 = new Person(5663, "Kordian", "Kołodziej", "Lipowa 12", "A+", patientCard2);
        PatientCard patientCard3 = new PatientCard();
        Person patient3 = new Person(82572, "Piotr", "Wiśniewski", "Słoneczna 22", "A+", patientCard3);
        PatientCard patientCard4 = new PatientCard();
        Person patient4 = new Person(82562, "Miron", "Mazurek", "Polna 15", "A+", patientCard4);
        PatientCard patientCard5 = new PatientCard();
        Person patient5 = new Person(86256565, "Bronisław", "Błaszczyk", "Akacjowa 9", "B+", patientCard5);
        PatientCard patientCard6 = new PatientCard();
        Person patient6 = new Person(2569425, "Alex", "Adamska", "Topolowa 4", "B+", patientCard6);
        PatientCard patientCard7 = new PatientCard();
        Person patient7 = new Person(624725773, "Jarosław", "Zieliński", "Dębowa 17", "B+", patientCard7);
        PatientCard patientCard8 = new PatientCard();
        Person patient8 = new Person(43736373, "Krzysztof", "Zalewski", "Brzozowa 3", "B+", patientCard8);
        PatientCard patientCard9 = new PatientCard();
        Person patient9 = new Person(6373673, "Roman", "Lis", "Wąska 11", "B+", patientCard9);
        PatientCard patientCard10 = new PatientCard();
        Person patient10 = new Person(663732, "Kacper", "Makowski", "Jesienna 8", "B+", patientCard10);

        Treatment treatment1 = new Treatment();
        Treatment treatment2 = new Treatment();
        Treatment treatment3 = new Treatment();
        Treatment treatment4 = new Treatment();
        Treatment treatment5 = new Treatment();
        Treatment treatment6 = new Treatment();
        Treatment treatment7 = new Treatment();
        Treatment treatment8 = new Treatment();
        Treatment treatment9 = new Treatment();
        Treatment treatment10 = new Treatment();
        treatment1.startTreatment(doctor1, patient1);
        treatment2.startTreatment(doctor1, patient2);
        treatment3.startTreatment(doctor1, patient3);
        treatment4.startTreatment(doctor1, patient4);
        treatment5.startTreatment(doctor1, patient5);
        treatment6.startTreatment(doctor1, patient6);
        treatment7.startTreatment(doctor1, patient7);
        treatment8.startTreatment(doctor1, patient8);
        treatment9.startTreatment(doctor1, patient9);
        treatment10.startTreatment(doctor1, patient10);

        System.out.println(treatment1);
        treatment1.setOperationNeeded(true);
        System.out.println(patient1);
        System.out.println(doctor1);
        treatment1.finishTreatment();
        System.out.println(patient1.getPatientCard());
    }
}
