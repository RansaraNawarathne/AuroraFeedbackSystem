
package AFS.Utilities;

public class AgeNullValueException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Age!";
    }
}
