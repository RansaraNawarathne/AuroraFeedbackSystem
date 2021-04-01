package AFS.DatabaseLayer;

//import java.sql.Connection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static DatabaseConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dcon == null) {
            dcon = new DatabaseConnection();
        }
        return dcon;
    }

    public Connection getConnection() {
        return con;
    }
}
