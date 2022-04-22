package cz.denny.itccave;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Private Repository class
 */
public class PersonRepo {
    private final List<Person> peopleRepo = new ArrayList<>();
    private static PersonRepo personRepo;
    private PersonRepo() {}

    /**
     * Static method to get instance of personRepo
     * @return new personRepo
     */
    public static PersonRepo getInstance(){
        if (personRepo==null) {
            personRepo = new PersonRepo();
        }
        return personRepo;
    }

    /**
     * Method to populate the repository with test data
     */
    public void createTestData() {
        // test data to populate repo
        addPerson(new Insuree(1, "ONE", "TWO", LocalDate.of(0, 1, 1), "NA", "127.0.0.1", "1", LocalDate.of(1, 1, 1), "Local Host"));
        addPerson(new Insuree(2, "DATE", "BEGAN", LocalDate.of(1970, 1, 1), "UNKNOWN", "420-696969696", "SILICON", LocalDate.of(1970, 1, 1), "FIRST ACCOUNT"));
        addPerson(new Insuree(3, "JAVA", "JAVA", LocalDate.of(1995, 5, 1), "Female", "0010 0010 1011", "SILICON", LocalDate.of(1995, 5, 1), "FIRST ACCOUNT"));
        addPerson(new Insuree(4, "Zoe", "Ski", LocalDate.of(2022, 3, 21), "Female", "420-123456789", "Life", LocalDate.of(2022, 4, 20), "fresh account"));
        addPerson(new Insuree(5, "Denny", "Ski", LocalDate.of(1986, 6, 14), "Male", "420-112233445", "Car", LocalDate.of(2021, 3, 1), "no claim"));
        addPerson(new Insuree(6, "Zuka", "Bazukaski", LocalDate.of(1988, 4, 28), "Female", "420-987654321", "House", LocalDate.of(2002, 7, 3), "on time"));
    }

    /**
     * Method to add a person to the repository.
     * @param person person
     */
    public void addPerson(Person person) {
        peopleRepo.add(person);
    }

    /**
     * Method to get entire repo.
     * @return peopleRepo
     */
    public List<Person>getAllRecords() {
        return peopleRepo;
    }
    public List<Person>search(LocalDate dateOfBirth) {
        List<Person> resultList = new ArrayList<>();
        for (Person person : peopleRepo)
            if (person.getDayOfBirth().equals(dateOfBirth))
                resultList.add(person);
        return resultList;
    }
    public List<Person>search(String surname) {
        List<Person>resultList = new ArrayList<>();
        for (Person person : peopleRepo)
            if (person.getSurname().equalsIgnoreCase(surname))
                resultList.add(person);
        return resultList;
    }
    public List<Person>search(String name, String surname) {
        List<Person>resultList = new ArrayList<>();
        for (Person person : peopleRepo)
            if (person.getName().equalsIgnoreCase(name) && person.getSurname().equalsIgnoreCase(surname))
                resultList.add(person);
        return resultList;
    }
}
