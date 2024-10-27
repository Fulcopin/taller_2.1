package labcodeinspection;

import java.util.Locale;

/**
 * Class representing an Email associated with a user.
 * 
 * @author CltControl
 */
public class Email {

    private final String m_firstName; // NOPMD This field 
    private final String m_lastName;  // NOPMD This field 
    private String password;           // NOPMD This field 
    private String department;         // NOPMD This field 
    private final int defaultPasswordLength = 8; // NOPMD This field 
    private String email;              // NOPMD This field 

    /**
     * Constructor for the Email class.
     * 
     * @param firstName User's first name.
     * @param lastName  User's last name.
     */
    public Email(final String firstName, final String lastName) { // Parameters declared final
        this.m_firstName = firstName;
        this.m_lastName = lastName;
    }

    /**
     * Displays the user's information.
     * 
     * @author FULCO
     */
    public void showInfo() {
        if (logger.isLoggable(java.util.logging.Level.INFO)) {
            logger.info("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
            logger.info("DEPARTMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
        }
    }
    /**
     * Sets the user's department based on the choice.
     * 
     * @param depChoice Department choice.
     */
    public void setDepartment(final int depChoice) { // Parameter declared final
        switch (depChoice) {
            case 1:
                this.department = "sales";
                break;
            case 2:
                this.department = "dev";
                break;
            case 3:
                this.department = "acct";
                break;
            default:
                break;
        }
    }

    /**
     * Generates a random password of a specific length.
     * 
     * @param length Desired password length.
     * @return The generated password.
     */
    private String randomPassword(final int length) {
        final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
        final char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            final int rand = (int) (Math.random() * set.length());
            password[i] = set.charAt(rand);
        }
        return new String(password);
    }
    /**
     * Generates the user's email address.
     * 
     * @author FULCO
     */
    public void generateEmail() {
        this.password = this.randomPassword(this.defaultPasswordLength);
        this.email = this.m_firstName.toLowerCase(Locale.US) + this.m_lastName.toLowerCase(Locale.US) + "@" + this.department
                + ".espol.edu.ec";
    }
}
