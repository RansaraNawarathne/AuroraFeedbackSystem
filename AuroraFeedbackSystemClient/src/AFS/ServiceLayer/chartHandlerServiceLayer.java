// This class is only develop for only testing purposes only
package AFS.ServiceLayer;

import AFS.Interface.AFSRMIConnector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class chartHandlerServiceLayer {
   
    public boolean chartManager ( int qno ) {
        try {
            boolean finalStatus = false;
            boolean analyseStatus = false;
            String charturl = "";
            BufferedImage chartimg = null;
            AFSRMIConnector generateChart = new AFSRMIConnector();
            analyseDataSericeLayer analyser = new analyseDataSericeLayer();
            analyseStatus = analyser.analyseData();
            if ( analyseStatus == true ) {
                charturl = generateChart.afsconnector().createChart("bar", qno);
                System.out.println("Chart URL: " +charturl);
                URL cUrl = new URL(charturl);
                chartimg = ImageIO.read(cUrl);
                ImageIO.write(chartimg, "png",new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart"+qno+".png"));
                ImageIcon chr = new ImageIcon("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart"+qno+".png");
            } else {
                
            }
            return finalStatus;
        } catch (RemoteException ex) {
            Logger.getLogger(chartHandlerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(chartHandlerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(chartHandlerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
