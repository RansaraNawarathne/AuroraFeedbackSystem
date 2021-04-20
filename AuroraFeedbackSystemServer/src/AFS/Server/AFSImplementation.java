/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Server;

import AFS.Interface.AFSInterface;
import AFS.Models.driver;
import AFS.Models.reservation;
import AFS.Models.result;
import AFS.ServiceLayer.AFSChartGenerator;
import AFS.ServiceLayer.AFSEmailService;
import AFS.ServiceLayer.adminLoginServiceLayer;
import AFS.ServiceLayer.analyticServiceLayer;
import AFS.ServiceLayer.customerLoginServiceLayer;
import AFS.ServiceLayer.driverServiceLayer;
import AFS.ServiceLayer.reservationServiceLayer;
import AFS.ServiceLayer.resultServiceLayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    public boolean getReservation(reservation resv) throws RemoteException {
        reservationServiceLayer resvsl = new reservationServiceLayer();
        boolean dbresponse = false;
        dbresponse = resvsl.saveReservation(resv);
        return dbresponse;
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
     public boolean analyseData () throws RemoteException {
         boolean status = false;
         status = analyticServiceLayer.analyseProcess();
         return status;
     }
     @Override
     public String createChart (String cType, int qnum ) throws RemoteException {
         String chartUrl = "";
         AFSChartGenerator chart = new AFSChartGenerator();
         chartUrl = chart.generateChart (cType, qnum);
         return chartUrl;
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

     @Override
     public boolean addNewDriver ( driver drv ) throws RemoteException {
         boolean stateRes = false;
         driverServiceLayer drvsvl = new driverServiceLayer();
         stateRes = drvsvl.saveDriver ( drv );
         return stateRes;
     }
     
     @Override
     public driver searchdriver ( String email ) throws RemoteException {
         driver drv = null;
         driverServiceLayer drvsvl1 = new driverServiceLayer();
         drv = drvsvl1.searchDriver ( email );
         return drv;
     }
     
     @Override
     public boolean updateDriver ( String email, driver drv1 ) throws RemoteException {
         boolean stateRes = false;
         driverServiceLayer drvsvl2 = new driverServiceLayer();
         stateRes = drvsvl2.editDriver ( email, drv1 );
         return stateRes;
     }
     
     @Override
     public boolean deleteDriver ( String email ) throws RemoteException {
         boolean stateRes = false;
         driverServiceLayer drvsvl3 = new driverServiceLayer();
         stateRes = drvsvl3.deleteDriver ( email );
         return stateRes;
     }
}
