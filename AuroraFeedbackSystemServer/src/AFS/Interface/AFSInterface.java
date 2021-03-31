/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Interface;

import AFS.Models.question;
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
    public boolean getAnswer ( result[] resultObjArray, String invID ) throws RemoteException;
    public void sendEmail (String recEmail, String resSub, String resMsg) throws RemoteException;
}