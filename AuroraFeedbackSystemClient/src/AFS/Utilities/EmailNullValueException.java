
package AFS.Utilities;

/**
 * Email Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class EmailNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Email!";
    }
}
