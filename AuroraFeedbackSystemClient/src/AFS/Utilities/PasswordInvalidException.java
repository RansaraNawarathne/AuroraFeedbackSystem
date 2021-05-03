
package AFS.Utilities;

/**
 * Password invalid exception
 * @author Malindu Ransara Nawarathne
 */
public class PasswordInvalidException extends RuntimeException {
    /**
     * Override localized message 
     * @return customized localized message
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Password!";
    }
}
