//This class is only develop for tesring purposes 
package AFS.ServiceLayer;

import AFS.Interface.AFSRMIConnector;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class analyseDataSericeLayer {
    
    public boolean analyseData () {
        try {
            boolean finalStatus = false;
            AFSRMIConnector analyser = new AFSRMIConnector();
            finalStatus = analyser.afsconnector().analyseData();
            return finalStatus;
        } catch (RemoteException ex) {
            Logger.getLogger(analyseDataSericeLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
