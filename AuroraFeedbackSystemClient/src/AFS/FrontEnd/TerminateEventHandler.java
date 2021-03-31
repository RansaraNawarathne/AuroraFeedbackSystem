
package AFS.FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminateEventHandler implements ActionListener {
    @Override
    public void  actionPerformed (ActionEvent e) {
        System.exit(0);
    }
}
