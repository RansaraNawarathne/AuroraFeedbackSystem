
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.reservation;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class reservationServiceLayer {
    private static Connection conn;
    private static PreparedStatement prst;
    
    public boolean saveReservation ( reservation resv ) {
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
}
