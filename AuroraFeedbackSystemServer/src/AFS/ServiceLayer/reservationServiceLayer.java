
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.reservation;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reservation Service Layer
 * @author Malindu Ransara Nawarathne
 */
public class reservationServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static PreparedStatement prst;
    private static ResultSetImpl rsts;
    
    /**
     * Save new reservation data in to the database
     * @param resv: Reservation object
     * @return the status of the process
     */
    public static boolean saveReservation ( reservation resv ) {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("INSERT INTO `reservation` (`invNo`, `driverID`, `vehicleID`) VALUES (?, ?, ?);");
            
            prst.setObject(1, resv.getInvID());
            prst.setObject(2, resv.getDrvID());
            prst.setObject(3, resv.getVehID());
            
            boolean res = false;
            
            if ( prst.executeUpdate() > 0 ) {
                res = true;
            }
            
            return res;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Generate invoice number 
     * @return the generated invoice number
     */
    public static String generateInvoiceNo () {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            /*
            Tutorialspoint.com. 2021. How to select last row in MySQL?. [online] Available at: <https://www.tutorialspoint.com/how-to-select-last-row-in-mysql>.
            */
            rsts = (ResultSetImpl) state.executeQuery("SELECT `invNo` FROM `reservation` ORDER BY `invNo` DESC LIMIT 1;");

            String lstItemNo = "afs2021";
            while (rsts.next()) {
                lstItemNo = rsts.getString(1);
            }

            int getNumValue = Integer.parseInt(lstItemNo.substring(3));

            int genNova = getNumValue + 1;
            String newID = "afs" + genNova;

            return newID;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Search reservation records in the database
     * @param seaInvNo: Invoice number
     * @return the reservations found
     */
    public static reservation searchReservation ( String seaInvNo ) {
        try {
            reservation res2 = null;
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = (ResultSetImpl) state.executeQuery("SELECT * FROM `reservation` WHERE `invNo` = '"+seaInvNo+"';");
            
            while ( rsts.next() ) {
                res2 = new reservation( rsts.getString(1), rsts.getString(2), rsts.getString(3) );
            }
            return res2;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Update reservation records
     * @param seaIinvNo: Invoice number
     * @param res3: Reservation object with updated values
     * @return the status of the project
     */
    public static boolean editReservation ( String seaIinvNo, reservation res3 ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("UPDATE `reservation` SET `driverID`='"+res3.getDrvID()+"',`vehicleID`='"+res3.getVehID()+"' WHERE `invNo` = '"+seaIinvNo+"';");
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Delete reservation records in the database
     * @param seaInvNo: Invoice number
     * @return the status of the process
     */
    public static boolean deleteReservation ( String seaInvNo ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("DELETE FROM `reservation` WHERE `invNo` = '"+seaInvNo+"';");
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(reservationServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
