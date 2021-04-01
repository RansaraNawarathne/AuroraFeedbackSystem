
package AFS.Utilities;

public class invoiceNullValueException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a valid Invoice Number!";
    }
}
