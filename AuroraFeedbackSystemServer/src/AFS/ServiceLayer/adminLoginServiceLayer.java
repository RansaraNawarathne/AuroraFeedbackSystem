
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class adminLoginServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static ResultSet rsts;
    
    public static boolean validateAdmin (String uname, String password) {
        try {
            String finalRes = "";
            conn = DatabaseConnection.getInstance().getConnection();
            state = conn.createStatement();
            rsts = state.executeQuery("SELECT * FROM `adminaccounts` WHERE `username` = '"+uname+"' AND `password` = '"+password+"';");
            
            while (rsts.next()) {
                finalRes = rsts.getString("username");              
            }
            if ( finalRes == "" ) {
                return false;
            } else {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminLoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(adminLoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
