
package AFS.Utilities;

/**
 * Name Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class NameNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter Valid Name!";
    }
}
