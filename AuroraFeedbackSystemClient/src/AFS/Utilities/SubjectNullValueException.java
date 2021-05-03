
package AFS.Utilities;

/**
 * Subject null value exception
 * @author Malindu Ransara Nawarathne
 */
public class SubjectNullValueException extends RuntimeException  {
    /**
     * Override localized message 
     * @return customized localized message
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Subject!";
    }
}
