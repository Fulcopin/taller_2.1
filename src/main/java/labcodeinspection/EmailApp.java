package labcodeinspection;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * EmailApp class that interacts with the user to create an email based on 
 * provided first name, last name, and department choice.
 */
public class EmailApp {

    // Logger instance for the class
    private static final Logger logger = Logger.getLogger(EmailApp.class.getName());

    private EmailApp() {
        // Private constructor to prevent instantiation
    }

    /**
     * Main method to run the EmailApp.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            
            logger.log(Level.INFO, "Enter your first name: ");
            final String firstName = scanner.nextLine();

            logger.log(Level.INFO, "Enter your last name: ");
            final String lastName = scanner.nextLine();

            logger.log(Level.INFO, "\nDEPARTMENT CODE\n1. for Sales\n2. for Development\n3. for Accounting\nEnter code: ");
            final int depChoice = scanner.nextInt();

            final Email email = new Email(firstName, lastName);
            email.setDepartment(depChoice);
            email.generateEmail();
            email.showInfo();
        }
    }
}
