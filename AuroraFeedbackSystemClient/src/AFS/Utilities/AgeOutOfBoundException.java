
package AFS.Utilities;

/**
 * Age Out of Bound Value exception
 * @author Malindu Ransara Nawarathne
 */
public class AgeOutOfBoundException extends RuntimeException {

    /**
     * Override localized message 
     * @return customized localized message  
     */
    @Override
    public String getLocalizedMessage () {
        return "Please Enter a Valid Age (Age Between 19 to 60)!";
    }
}
