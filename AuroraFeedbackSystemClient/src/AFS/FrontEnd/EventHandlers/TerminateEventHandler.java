
package AFS.FrontEnd.EventHandlers;

import AFS.ServiceLayer.adminSessionManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Terminate Event Handler
 * @author Malindu Ransara Nawarathne
 */
public class TerminateEventHandler implements ActionListener {

    /**
     * Terminate the current window and close the application
     * @param e: ActionEvent object
     */
    @Override
    public void  actionPerformed (ActionEvent e) {
        //To reset cookie, terminate the current window and close application
        adminSessionManagement.resetCookie();
        System.exit(0);
    }
}
