
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.question;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class questionServiceLayer {
    private static Connection conn;
    private static Statement state;
    private static ResultSet rsts;
    
    public static question retrieveQuestions ( int qno ) {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            state = conn.createStatement();
            rsts = state.executeQuery("SELECT * FROM `questions` WHERE `qno` = "+qno+";");
            
            question ques = null;
            while (rsts.next()) {
                ques = new question(rsts.getInt(1), rsts.getString(2), rsts.getString(3), rsts.getString(4), rsts.getString(5), rsts.getString(6));
            }
            
            return ques;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(questionServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(questionServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
