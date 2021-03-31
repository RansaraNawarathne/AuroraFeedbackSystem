/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Server;

import AFS.Interface.AFSInterface;
import AFS.Models.question;
import AFS.Models.result;
import AFS.ServiceLayer.AFSEmailService;
import AFS.ServiceLayer.adminLoginServiceLayer;
import AFS.ServiceLayer.customerLoginServiceLayer;
import AFS.ServiceLayer.resultServiceLayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 *
 * @author ransa
 */
public class AFSImplementation extends UnicastRemoteObject implements AFSInterface {
    private static final long serialVersionUID = -3763231206310448L;
    
     AFSImplementation() throws RemoteException {
         super();
     }
     @Override
     public boolean validateInvoiceNo (String inv) throws RemoteException {
         boolean finalResult = false;
         finalResult = customerLoginServiceLayer.validateUser(inv);
         return finalResult;
     }
     @Override
     public boolean validateAdminLogin ( String uname, String Password ) throws RemoteException {
         boolean finalResult = false;
         finalResult = adminLoginServiceLayer.validateAdmin(uname, Password);
         return finalResult;
     }
     @Override
     public String createCookie (String invNum) throws RemoteException {
         String storedCookieValue = "";
         storedCookieValue = invNum+": "+Math.random();
         return storedCookieValue;
     }
     @Override
     public boolean getAnswer ( result[] resultObjArray, String invID ) throws RemoteException {
         resultServiceLayer rstsl = new resultServiceLayer();
         for ( int x = 0; x < 10; x++ ) {
                System.out.println("Question Number: "+resultObjArray[x].getQno());
                System.out.println("Response: "+resultObjArray[x].getAnswer());
            }
         boolean dbresponse = false;
         dbresponse = rstsl.saveResponse (resultObjArray, invID);
         return dbresponse;
     }
     @Override
     public void sendEmail (String recEmail, String resSub, String resMsg) throws RemoteException {
         AFSEmailService eml = new AFSEmailService(recEmail, resSub, resMsg);
         System.out.println("Rec Email: "+eml.getRecEmail() );
         System.out.println("Rec Subject: "+eml.getRecSubject());
         System.out.println("Rec Message: "+eml.getMsg());
         String val = "";
         val = eml.sendMail();
         System.out.println("Eamil successfully sent! " + val);
     }
     
}
