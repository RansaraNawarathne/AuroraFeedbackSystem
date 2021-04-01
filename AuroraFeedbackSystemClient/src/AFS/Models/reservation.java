
package AFS.Models;

import java.io.Serializable;

public class reservation implements Serializable {
    private String invID;
    private String drvID;
    private String vehID;

    public reservation(String invID, String drvID, String vehID) {
        this.invID = invID;
        this.drvID = drvID;
        this.vehID = vehID;
    }

    public String getInvID() {
        return invID;
    }

    public String getDrvID() {
        return drvID;
    }

    public String getVehID() {
        return vehID;
    }
    
}
