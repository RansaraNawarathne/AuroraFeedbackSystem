
package AFS.Utilities;

/**
 * Message null value exception 
 * @author Malindu Ransara Nawarathne
 */
public class MessageNullValueException extends RuntimeException {
    /**
     * Override localized message 
     * @return customized localized message
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Message!";
    }
}
