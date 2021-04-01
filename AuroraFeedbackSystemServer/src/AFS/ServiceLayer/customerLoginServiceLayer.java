
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class customerLoginServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static ResultSet rsts;
    
    public static boolean validateUser (String invNo) {
        try {
            String retData = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT * FROM `reservation` WHERE `invNo` = '"+invNo+"';");
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
