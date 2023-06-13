package s22678.Controller;

import s22678.Model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonController {
    public static boolean isPESELLengthIncorrect(String PESEL) {
        if (PESEL.length() != 11) {
            System.out.println("Incorrect PESEL length: " + PESEL.length());
            return true;
        }
        return false;
    }

    public static boolean isPESELIncorrectlyFormated(String PESEL) {
        String birthDay = getBirthday(PESEL);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        try {
            LocalDate.parse(birthDay, formatter);
        } catch (Exception e) {
            System.out.println("Error while parsing PESSEL - incorrect data: " + birthDay);
            return true;
        }
        return false;
    }

    public static boolean doesPeselExist(String PESEL) {
        for (Person person : Person.getExtent().values()) {
            if (person.getPESEL().equals(PESEL)) return true;
        }
        return false;
    }

    public static String getBirthday(String PESEL) {
        if (Character.getNumericValue(PESEL.charAt(2)) > 1) {
            int intMonth = Character.getNumericValue(PESEL.charAt(2)) - 2;
            String strMonth = String.valueOf(intMonth);
            return PESEL.substring(0, 2) + strMonth + PESEL.substring(3, 6);
        } else {
            return PESEL.substring(0, 6);
        }
    }
}
