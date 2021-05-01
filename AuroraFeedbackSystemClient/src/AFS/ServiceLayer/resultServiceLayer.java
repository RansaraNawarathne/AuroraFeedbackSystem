
package AFS.ServiceLayer;

import AFS.FrontEnd.question1;
import AFS.Models.result;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ransa
 */
public class resultServiceLayer {
    private result[] rs;
    private int index;
    
    /**
     *
     */
    public resultServiceLayer () {
        rs = new result[10];
        index = 0;
    }
    
    /**
     *
     * @param res
     */
    public void addResults (result res){
        rs[index] = res;
        index++;
    }
    
    //To save answer locally

    /**
     *
     * @param res
     * @param qno
     */
    public void saveAnswer ( result res, int qno ) {
        FileOutputStream FileOutStr = null;
        try {
            FileOutStr = new FileOutputStream(new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\localResults\\ans"+qno+".afs"));
            ObjectOutputStream OutStr = new ObjectOutputStream(FileOutStr);
            OutStr.writeObject(res);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(question1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(question1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                FileOutStr.close();
            } catch (IOException ex) {
                Logger.getLogger(question1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
