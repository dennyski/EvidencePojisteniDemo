package cz.denny.itccave;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * IOHandler takes care of user data manupulation
 */
public class IOHandler {
    //    2do extend data manipulation
    private static final Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
//    private static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("d'.'M'.'y");

    /**
     * Method to create a new insuree
     *
     * @return Insuree(name, surname, dob, gender)
     */
    public static Person createPerson() {
        try {
            System.out.print("person ID: ");
            String personID = (sc.nextLine().trim());
            System.out.print("Name: ");
            String name = (sc.nextLine().trim());
            System.out.print("Surname: ");
            String surname = (sc.nextLine().trim());
            System.out.print("DoB [format d.m.yyyy]: ");
            LocalDate dateOfBirth = (LocalDate.parse(sc.nextLine().trim(), DateTimeUtils.FORMAT_DATE));
            System.out.print("Gender [male, female, don't wish to say]: ");
            String gender = (sc.nextLine().toUpperCase().trim());
            System.out.print("Phone No.: ");
            String phoneNo = (sc.nextLine().trim());
            System.out.print("Policy Type: ");
            String policyType = (sc.nextLine().trim());
            LocalDate policyStartDate = LocalDate.now();
            System.out.print("Note: ");
            String note = (sc.nextLine().trim());
            return new Insuree(Integer.parseInt(personID), name, surname, dateOfBirth, gender, phoneNo, policyType, policyStartDate, note);
        } catch (Exception ex) {
            return null;
        }
    }

    public static void listAllRecords(List<Person> list) {
        // check condition
        if (list.isEmpty())
            System.out.println("No records found");
        // foreach loop to iterate through list of people
        for (Person person : list) {
            System.out.println(person.toString());
        }
    }

    public static Person filterBySurname() {
        System.out.print("Surname: ");
        String surname;
        surname = (sc.nextLine().trim());
        if (surname.matches("\\d+")) { // checks if input only contains digits
            System.out.println("Invalid input, should contain only letters");
        } else  // valid input
            System.out.println("Valid input");
        return new Insuree(surname);
    }

    public static Person filterByFullName() {
        try {
            System.out.print("Name: ");
            String name = (sc.nextLine().trim());
            System.out.print("Surname: ");
            String surname = (sc.nextLine().trim());
            return new Insuree(name, surname);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Person filterByDoB() {
        System.out.print("[d.m.y]: ");
        while (true) {
            try {
                LocalDate dayOfBirth = LocalDate.parse(sc.nextLine().trim(), DateTimeUtils.FORMAT_DATE);
                return new Insuree(dayOfBirth);
            } catch (Exception ex) {
                System.out.println("Incorrect date format [day.month.year]");
            }
        }
    }
}
