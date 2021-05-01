
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Customer Login Service Layer
 * @author Malindu Ransara Nawarathne
 */
public class customerLoginServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static ResultSetImpl rsts;
    
    /**
     * Validate User Credentials
     * @param invNo: Invoice Number
     * @return the authentication status
     */
    public static boolean validateUser (String invNo) {
        try {
            String retData = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = (ResultSetImpl) state.executeQuery("SELECT * FROM `reservation` WHERE `invNo` = '"+invNo+"';");
            while ( rsts.next() ) {
                retData = rsts.getString("invNo");
            }
            if ( retData == "" ) {
                return false;
            } else {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customerLoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(customerLoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
