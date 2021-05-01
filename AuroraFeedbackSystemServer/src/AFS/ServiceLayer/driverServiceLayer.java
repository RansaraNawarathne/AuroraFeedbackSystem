
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.driver;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Driver Service Layer
 * @author Malindu Ransara Nawarathne
 */
public class driverServiceLayer {
    private static Connection conn;
    private static PreparedStatement prst;
    private static Statement state;
    private static ResultSetImpl rsts;
    
    /**
     * Save driver vales in the database
     * @param drv: Driver object
     * @return the status of the process
     */
    public static boolean saveDriver ( driver drv ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("INSERT INTO `driver` (`email`, `name`, `age`, `conNum`, `Address`) VALUES ('"+drv.getEmail()+"', '"+drv.getName()+"', '"+drv.getAge()+"', '"+drv.getConNum()+"', '"+drv.getAddress()+"');");
            
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Search driver records in the database
     * @param seaEmail: Email address of the driver
     * @return the driver object found
     */
    public static driver searchDriver ( String seaEmail ) {
        try {
            driver drv1 = null;
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = (ResultSetImpl) state.executeQuery("SELECT * FROM `driver` WHERE `email` = '"+seaEmail+"';");
            
            while ( rsts.next() ) {
                drv1 = new driver(rsts.getString(1), rsts.getString(2), rsts.getInt(3), rsts.getInt(4), rsts.getString(5));
            }
            return drv1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Update driver records
     * @param seaEmail: Email address of the driver
     * @param drv2: Driver object with updated data
     * @return the status of the process
     */
    public static boolean editDriver ( String seaEmail, driver drv2 ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("UPDATE `driver` SET `email`='"+drv2.getEmail()+"',`name`='"+drv2.getName()+"',`age`='"+drv2.getAge()+"',`conNum`='"+drv2.getConNum()+"',`Address`='"+drv2.getAddress()+"' WHERE `email` = '"+seaEmail+"';");
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Delete Driver Records
     * @param seaEmail: Email address of the driver
     * @return the status of the process
     */
    public static boolean deleteDriver ( String seaEmail ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("DELETE FROM `driver` WHERE `email`= '"+seaEmail+"';");
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(driverServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
