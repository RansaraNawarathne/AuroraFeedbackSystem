
package AFS.Utilities;

/**
 * Vehicle Plate Number Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class VehicleNumberNullException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Vehicle Number!";
    }
}
