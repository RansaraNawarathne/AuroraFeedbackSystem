
package AFS.Utilities;

/**
 * Address Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class AddressNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Address!";
    }
}
