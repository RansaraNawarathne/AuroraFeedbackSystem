
package AFS.Utilities;

/**
 * Vehicle Brand Null Value exception
 * @author Malindu Ransara Nawarathne
 */
public class VehicleBrandNullException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Vehicle Brand/Model!";
    }
}
