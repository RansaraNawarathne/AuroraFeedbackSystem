
package AFS.Utilities;

/**
 * Age Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class AgeNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Age!";
    }
}
