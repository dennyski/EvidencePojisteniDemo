package cz.denny.itccave;

import java.time.LocalDate;
import java.time.Period;

/**
 * Public class Person
 * extended by Insuree, eventually by User, Admin etc.
 */
public abstract class Person {

    private int personID;
    public String name = "";       // Why did I set this to private instead of protected?
    protected String surname = "";
    protected LocalDate dayOfBirth = null;
    protected String gender = null;

    public Person() {
    }

    public Person(int personID) {
        this.personID = personID;
    }

    public Person(String surname) {
        this.surname = surname;
    }

    public Person(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(int personID, String name, String surname) {
        this.personID = personID;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Constructor for a new Person with overloading
     *
     * @param personID   PersonID
     * @param name       Name
     * @param surname    Surname
     * @param dayOfBirth Day of Birth
     * @param gender     Gender (MALE/FEMALE/NA/UNKNOWN)
     */
    protected Person(int personID, String name, String surname, LocalDate dayOfBirth, String gender) {
        this.personID = personID;
        this.name = name;
        this.surname = surname;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
    }


// getters

    /**
     * @return personID
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return Day of Birth
     */
    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     * @return Age
     */
    public int getAge() {
        int age = Period.between(dayOfBirth, LocalDate.now()).getYears();
        if (age >= 100)
            return 99;
        return age;
    }

    /**
     * Is a Person an Adult?
     *
     * @return true/false
     */
    public boolean isAdult() {
        return getAge() >= 18;
    }

    /**
     * @return Gender
     */
    public String getGender() {
        return gender;
    }

// setters

    /**
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param surname Surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets Day of Birth
     *
     * @param dayOfBirth Day of Birth
     */
    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Sets gender of a person
     *
     * @param gender Gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Override toString method
     *
     * @return Name, Surname, Age, Gender
     */
    @Override
    public String toString() {
        return "personID" + "=[" + String.format("%05d", personID) + "] " +
                "Name" + "=[" + name + "] " +
                "Surname" + "=[" + surname + "] " +
                "Age" + "=[" + getAge() + "] " +
                "Gender" + "=[" + gender + "] " +
                "Adult" + "=[" + isAdult() + "] ";
    }
}
