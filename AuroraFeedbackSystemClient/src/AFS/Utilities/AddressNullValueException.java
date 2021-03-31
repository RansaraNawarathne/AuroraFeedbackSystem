
package AFS.Utilities;

public class AddressNullValueException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Address!";
    }
}
