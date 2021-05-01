
package AFS.Models;

import java.io.Serializable;

/**
 * Reservation models class
 * @author MAlindu Ransara Nawarathne
 */
public class reservation implements Serializable {
    private String invID;
    private String drvID;
    private String vehID;

    /**
     * Constructor: Create a reservation object
     * @param invID: Invoice number 
     * @param drvID: driver ID ( driver email )
     * @param vehID: vehicle ID ( Vehicle plate number )
     */
    public reservation(String invID, String drvID, String vehID) {
        this.invID = invID;
        this.drvID = drvID;
        this.vehID = vehID;
    }

    /**
     * Get the invoice number
     * @return the invoice number
     */
    public String getInvID() {
        return invID;
    }

    /**
     * Get the  driver ID
     * @return the driver ID
     */
    public String getDrvID() {
        return drvID;
    }

    /**
     * Get the vehicle ID
     * @return vehicle ID
     */
    public String getVehID() {
        return vehID;
    }
    
}
