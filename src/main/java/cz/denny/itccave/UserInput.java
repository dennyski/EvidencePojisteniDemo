package cz.denny.itccave;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInput {

    private final Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

    public UserInput() {
    }

    private void pressAnyKeyToContinue() {
        System.out.print("\nPress Enter");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

    public void input() {
//        if (DateTimeUtils.today == null)
        DateTimeUtils.getDateTime();
        PersonRepo repo = PersonRepo.getInstance();
        repo.createTestData();
        // while loop
        String userInput;
        while (true) {
            ConsoleMenu.menuMain();
            userInput = sc.nextLine().toLowerCase().trim();
            // enhanced switch approach
            switch (userInput) {
                case "1", "a" -> {
                    System.out.println("Creating a new Person");
                    Person person = IOHandler.createPerson();
                    if (person != null)
                        repo.addPerson(person);
                }
                case "2", "l" -> {
                    ConsoleMenu.clearScreen();
                    System.out.println("Listing All Records");
                    IOHandler.listAllRecords(repo.getAllRecords());
                }
                case "3", "s" -> {
                    // do while loop
                    String uiSearch;
                    do {
                        ConsoleMenu.menuSearch();
                        uiSearch = sc.nextLine().toLowerCase().trim();
                        // if else approach
                        if ("1".equals(uiSearch) || "n".equals(uiSearch)) {
                            System.out.println("Filter by Name and Surname");
                            Person person = IOHandler.filterByFullName();
                            assert person != null;
                            IOHandler.listAllRecords(repo.search(person.getName(), person.getSurname()));
                        } else if ("2".equals(uiSearch) || "s".equals(uiSearch)) {
                            System.out.println("Filter by Surname");
                            Person person = IOHandler.filterBySurname();
                            assert person != null;
                            IOHandler.listAllRecords(repo.search(person.getSurname()));
                        } else if ("3".equals(uiSearch) || "d".equals(uiSearch)) {
                            System.out.println("Filter by Date of Birth");
                            Person person = IOHandler.filterByDoB();
                            if (person == null) throw new AssertionError();
                            IOHandler.listAllRecords(repo.search(person.getDayOfBirth()));
                        } else if ("l".equals(uiSearch)) {
                            System.out.println("Hidden (L)ist of All records");
                            IOHandler.listAllRecords(repo.getAllRecords());
                        } else if ("4".equals(uiSearch) || "m".equals(uiSearch)) {
//                            System.out.println("Return to previous menu");
                            ConsoleMenu.clearScreen();
                            break;
                        } else
                            System.out.println("Invalid input\nOptions: 1/Add 2/List 3/Search 4/Exit");
                    } while (true);

                }
                case "h" -> {
                    ConsoleMenu.clearScreen();
                    ConsoleMenu.menuHelp();
                    pressAnyKeyToContinue();
                    ConsoleMenu.clearScreen();
                }
                case "c" -> {
                    ConsoleMenu.clearScreen();
                    ConsoleMenu.menuConfig();
                    pressAnyKeyToContinue();
                    ConsoleMenu.clearScreen();
                }
                case "i" -> {
                    ConsoleMenu.clearScreen();
                    ConsoleMenu.menuInfo();
                    pressAnyKeyToContinue();
                    ConsoleMenu.clearScreen();
                }
                case "4", "e", "q" -> {
                    ConsoleMenu.clearScreen();
                    ConsoleMenu.menuExit();
                    return;
                }
                default -> System.out.println("Invalid input\nSelection: 1/Add 2/List 3/Search 4/Exit");
            } //end switch
        } // end main while
    } //end input

}