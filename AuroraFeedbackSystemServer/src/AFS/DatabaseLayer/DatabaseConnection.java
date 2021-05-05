package AFS.DatabaseLayer;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database Connection Class referenced from Ramesh Wijerathne
 * @author Malindu Ransara Nawarathne
 */
public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dcon;
    
    private DatabaseConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Done");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/afs", "root", "");
            System.out.println("Connection Done");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Create database connection instance
     * @return the database connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static DatabaseConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dcon == null) {
            dcon = new DatabaseConnection();
        }
        return dcon;
    }

    /**
     * Create the connection
     * @return the connection
     */
    public Connection getConnection() {
        return con;
    }
}
