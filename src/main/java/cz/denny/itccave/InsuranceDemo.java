package cz.denny.itccave;

/**
 * A small exam project for IT-Network to handle (add, list, search and more)
 * insurance policy records, simulating database functionality (live repository).
 * ---------------------------------------------------------------------------------------------------------------------
 * Separated logic, data handling and user interaction.
 * UserInput implements methods for user interaction.
 * ArrayList encapsulated within the repository
 * IOHandler methods for safe content manipulation
 * and communication with repository.
 * ---------------------------------------------------------------------------------------------------------------------
 * 3 layers, helpers, reaction to user input, few control variables
 * ---------------------------------------------------------------------------------------------------------------------
 * Constructor with a private instance of Repository
 * while value = readLine != 0
 *     case value = 0
 *         person = io.readPerson
 *         repo.add( person );
 *     case value = 1
 *         list = repo.getPersons
 *         io.print( list )
 *     case value = 2
 *         list = repo.find
 *         io.print( list )
 * ---------------------------------------------------------------------------------------------------------------------
 * I consider a success that my girlfriend can operate the app with no struggle.
 * Feel free to contact me through my website itccave.cz Δεννυ‣ΙΤΓγαυε™ ΜΜΞΞΙΙ
 */

public class InsuranceDemo {
    public static void main(String[] args) {

        DateTimeUtils.printFull();
        new UserInput().input();

    }
}
