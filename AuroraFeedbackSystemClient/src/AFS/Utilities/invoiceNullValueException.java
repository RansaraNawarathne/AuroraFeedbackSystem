
package AFS.Utilities;

/**
 * Invoice Number Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class invoiceNullValueException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Invoice Number!";
    }
}
