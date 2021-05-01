
package AFS.Utilities;

/**
 * Vehicle Year of Manufacture Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class vehicleYOMNullException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Year oF Manufacture!";
    }
}
