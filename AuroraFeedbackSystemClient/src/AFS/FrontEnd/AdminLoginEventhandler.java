
package AFS.FrontEnd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AdminLoginEventhandler implements ActionListener {
    @Override
    public void  actionPerformed (ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Hi, Welcome");
    }
}
