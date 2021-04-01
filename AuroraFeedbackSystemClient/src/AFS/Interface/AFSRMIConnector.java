
package AFS.Interface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AFSRMIConnector {
    
    public AFSInterface afsconnector () {
        try {
            AFSInterface conn = (AFSInterface) Naming.lookup("rmi://localhost/AFSServer2021"); 
            return conn;
                    } catch (NotBoundException ex) {
            Logger.getLogger(AFSRMIConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AFSRMIConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AFSRMIConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
