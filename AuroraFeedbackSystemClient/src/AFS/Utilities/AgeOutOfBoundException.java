
package AFS.Utilities;

public class AgeOutOfBoundException extends RuntimeException {
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Age (Age Between 19 to 60)!";
    }
}
