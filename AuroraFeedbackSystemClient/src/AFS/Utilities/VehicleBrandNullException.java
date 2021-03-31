
package AFS.Utilities;

public class VehicleBrandNullException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Vehicle Brand/Model!";
    }
}
