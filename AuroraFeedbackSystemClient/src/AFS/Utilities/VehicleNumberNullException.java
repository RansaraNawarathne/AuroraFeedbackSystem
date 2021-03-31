
package AFS.Utilities;

public class VehicleNumberNullException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Vehicle Number!";
    }
}
