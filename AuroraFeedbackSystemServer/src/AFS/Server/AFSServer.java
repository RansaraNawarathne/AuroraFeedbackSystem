
package AFS.Server;

import AFS.Interface.AFSInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * AFS Server Class
 * @author Malindu Ransara Nawarathne
 */
public class AFSServer {

    /**
     * Server Main Method
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Server is starting.....");
        try {
        AFSInterface intf1 = new AFSImplementation();
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind ("AFSServer2021", intf1);
            System.out.println("Server is up and running!");
        } catch (RemoteException ex) {
            System.out.println("Warning!, Server is not running due to an error! " +ex.toString());
            ex.printStackTrace();
        }
    }
}
