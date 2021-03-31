
package AFS.Utilities;

public class NameNullValueException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter Valid Name!";
    }
}
