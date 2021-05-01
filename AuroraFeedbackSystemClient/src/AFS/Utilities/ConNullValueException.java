
package AFS.Utilities;

/**
 * Contact Number Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class ConNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Contact Number!";
    }
}
