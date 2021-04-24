
package AFS.Utilities;

public class EmailNullValueException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Email!";
    }
}
