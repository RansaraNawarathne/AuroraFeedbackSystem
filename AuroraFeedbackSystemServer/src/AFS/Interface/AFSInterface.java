
package AFS.Interface;

import AFS.Models.driver;
import AFS.Models.reservation;
import AFS.Models.result;
import AFS.Models.vehicle;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI Interface Class
 * @author Malindu Ransara Nawarathne
 */
public interface AFSInterface extends Remote {

    /**
     * Validate invoice number
     * @param inv: invoice number
     * @return validation status
     * @throws RemoteException
     */
    public boolean validateInvoiceNo (String inv) throws RemoteException;

    /**
     * Validate administrator login
     * @param uname: Username of the administrator
     * @param Password: password of the administrator
     * @return validation status
     * @throws RemoteException
     */
    public boolean validateAdminLogin ( String uname, String Password ) throws RemoteException;

    /**
     * Create a cookie
     * @param invNum: Invoice number
     * @return cookie value
     * @throws RemoteException
     */
    public String createCookie (String invNum) throws RemoteException;

    /**
     * Create a reservation
     * @param resv: Reservation object
     * @return status of the process
     * @throws RemoteException
     */
    public boolean getReservation ( reservation resv ) throws RemoteException;

    /**
     * Save response in the database
     * @param resultObjArray: Array of responses provide by a customer
     * @param invID: invoice number
     * @return status of the process
     * @throws RemoteException
     */
    public boolean getAnswer ( result[] resultObjArray, String invID ) throws RemoteException;

    /**
     * Analyze responses stored in the  database
     * @return status of the process
     * @throws RemoteException
     */
    public boolean analyseData () throws RemoteException;

    /**
     * Create chart URL
     * @param cType: Chart type
     * @param qnum: Question number
     * @return the URL of the chart
     * @throws RemoteException
     */
    public String createChart (String cType, int qnum ) throws RemoteException;

    /**
     * Send email 
     * @param recEmail: Receivers email
     * @param resSub: Subject of the mail
     * @param resMsg: Message of the mail
     * @throws RemoteException
     */
    public void sendEmail (String recEmail, String resSub, String resMsg) throws RemoteException;

    /**
     * Add new driver record
     * @param drv: driver object
     * @return status of the process
     * @throws RemoteException
     */
    public boolean addNewDriver ( driver drv ) throws RemoteException;

    /**
     * Search driver records in the database
     * @param email: Email address of the driver
     * @return the driver object
     * @throws RemoteException
     */
    public driver searchdriver ( String email ) throws RemoteException;

    /**
     * Update driver records
     * @param email: Email of the driver
     * @param drv1: driver object with updated values
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean updateDriver ( String email, driver drv1 ) throws RemoteException;

    /**
     * Delete driver records in the database
     * @param email: Email address of the driver
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean deleteDriver ( String email ) throws RemoteException;

    /**
     * Add new vehicle record
     * @param veh: Vehicle object
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean addNewVehicle ( vehicle veh ) throws RemoteException;

    /**
     * Search vehicle in the database
     * @param seaVehNum: Vehicle plate number
     * @return the status of the process
     * @throws RemoteException
     */
    public vehicle searchVehicle ( String seaVehNum ) throws RemoteException;

    /**
     * Update the value of the vehicle
     * @param seaVehNum: Vehicle plate number
     * @param veh1: vehicle object with the updated values
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean updateVehicle ( String seaVehNum, vehicle veh1 ) throws RemoteException;

    /**
     * Delete vehicle records in the database
     * @param seaVehNum: Vehicle plate number
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean deleteVehicle ( String seaVehNum ) throws RemoteException;

    /**
     * Generate invoice number
     * @return generated invoice number
     * @throws RemoteException
     */
    public String generateInvoiceNumber ()throws RemoteException;

    /**
     * Search reservation record in the  database
     * @param seaIvnNum: Invoice number
     * @return the reservation object
     * @throws RemoteException
     */
    public reservation searchReservation ( String seaIvnNum ) throws RemoteException;

    /**
     * Update the reservation record in the database
     * @param seaInvNum: Invoice number
     * @param res1: reservation object
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean updateReservation ( String seaInvNum, reservation res1 ) throws RemoteException;

    /**
     * Delete the reservation records in the database
     * @param seaInvNum: Invoice number
     * @return the status of the process
     * @throws RemoteException
     */
    public boolean deleteReservation ( String seaInvNum ) throws RemoteException;
}
