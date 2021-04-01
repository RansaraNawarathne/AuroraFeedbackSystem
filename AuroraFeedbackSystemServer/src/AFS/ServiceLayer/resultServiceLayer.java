/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.result;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ransa
 */
public class resultServiceLayer {
    private static Connection conn;
    private static PreparedStatement prst;
    
    public boolean saveResponse (result[] rsultObj, String invID ) {
        try {
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("INSERT INTO `response` (`invNo`, `question1`, `question2`, `question3`, `question4`, `question5`, `question6`, `question7`, `question8`, `question9`, `question10`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            prst.setObject(1, invID);
            prst.setObject(2, rsultObj[0].getAnswer());
            prst.setObject(3, rsultObj[1].getAnswer());
            prst.setObject(4, rsultObj[2].getAnswer());
            prst.setObject(5, rsultObj[3].getAnswer());
            prst.setObject(6, rsultObj[4].getAnswer());
            prst.setObject(7, rsultObj[5].getAnswer());
            prst.setObject(8, rsultObj[6].getAnswer());
            prst.setObject(9, rsultObj[7].getAnswer());
            prst.setObject(10, rsultObj[8].getAnswer());
            prst.setObject(11, rsultObj[9].getAnswer());
            
            boolean res = false;
            if (prst.executeUpdate() > 0)
            {
                res = true;
            }
            
            return res;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(resultServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(resultServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
