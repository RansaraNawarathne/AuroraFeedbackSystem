
package AFS.Models;

import java.io.Serializable;

/**
 * Administrator model class
 * @author Malindu Ransara Nawarathne
 */
public class administrator implements Serializable{
    private static String username;
    private static String password;
    private static String serverKey;

    /**
     * Constructor: Create administrator object
     * @param username: Username of the administrator
     * @param password: Password of the administrator
     * @param serverKey: Server generated key
     */
    public administrator(String username, String password, String serverKey) {
        administrator.username = username;
        administrator.password = password;
        administrator.serverKey = serverKey;
    }

    /**
     * Get username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     * @return the username
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get server generated key
     * @return the server generated key
     */
    public String getServerKey() {
        return serverKey;
    }
}
