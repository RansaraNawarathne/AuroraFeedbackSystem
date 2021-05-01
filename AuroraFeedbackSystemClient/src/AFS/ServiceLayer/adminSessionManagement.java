package AFS.ServiceLayer;

import AFS.FrontEnd.customerLogin;
import AFS.Models.administrator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Administrator Session Management
 *
 * @author Malindu Ransara Nawarathne
 */
public class adminSessionManagement {

    /**
     * Create cookie with a unique ID
     * @param adminCookie: Administrator object
     */
    public static void CreateCookie(administrator adminCookie) {
        try {
            FileOutputStream filOut = null;
            filOut = new FileOutputStream(new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\localResults\\adminCookie.ckafs"));
            ObjectOutputStream outStr = new ObjectOutputStream(filOut);
            outStr.writeObject(adminCookie);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(customerLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(customerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Validate whether the session is set or not
     * @return the status of the process
     */
    public static boolean sessionValidate() {
        try {
            FileInputStream localFileInpStr = null;
            localFileInpStr = new FileInputStream(new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\localResults\\adminCookie.ckafs"));
            ObjectInputStream localInpStr = new ObjectInputStream(localFileInpStr);
            administrator tempAdmin = null;
            tempAdmin = (administrator) localInpStr.readObject();
            if ( tempAdmin != null ) {
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminSessionManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminSessionManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminSessionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Reset the cookie value
     */
    public static void resetCookie () {
        try {
            administrator resetAdmin = null;
            FileOutputStream filOut = null;
            filOut = new FileOutputStream(new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\localResults\\adminCookie.ckafs"));
            ObjectOutputStream outStr = new ObjectOutputStream(filOut);
            outStr.writeObject(resetAdmin);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(customerLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(customerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
