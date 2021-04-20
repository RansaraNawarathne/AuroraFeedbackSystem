/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Interface;

import AFS.Models.driver;
import AFS.Models.question;
import AFS.Models.reservation;
import AFS.Models.result;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ransa
 */
public interface AFSInterface extends Remote {
    public boolean validateInvoiceNo (String inv) throws RemoteException;
    public boolean validateAdminLogin ( String uname, String Password ) throws RemoteException;
    public String createCookie (String invNum) throws RemoteException;
    public boolean getReservation ( reservation resv ) throws RemoteException;
    public boolean getAnswer ( result[] resultObjArray, String invID ) throws RemoteException;
    public boolean analyseData () throws RemoteException;
    public String createChart (String cType, int qnum ) throws RemoteException;
    public void sendEmail (String recEmail, String resSub, String resMsg) throws RemoteException;
    public boolean addNewDriver ( driver drv ) throws RemoteException;
    public driver searchdriver ( String email ) throws RemoteException;
    public boolean updateDriver ( String email, driver drv1 ) throws RemoteException;
    public boolean deleteDriver ( String email ) throws RemoteException;
}
