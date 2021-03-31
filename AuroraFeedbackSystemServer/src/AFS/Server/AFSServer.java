/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Server;

import AFS.Interface.AFSInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ransa
 */
public class AFSServer {
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
