
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.analytic;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class analyticServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static ResultSet rsts;
    
    public static analytic retrieveAnalyticData (int qno) {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = state.executeQuery("SELECT * FROM `analysed` WHERE `questionNo` = "+qno+";");
            
            analytic res = null;
            
            while ( rsts.next() ) {
                res = new analytic(rsts.getInt(1), rsts.getInt(2), rsts.getInt(3), rsts.getInt(4), rsts.getInt(5));
            }
            
            return res;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(analyticServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
