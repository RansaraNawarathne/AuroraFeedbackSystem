
package AFS.FrontEnd;

import AFS.FrontEnd.EventHandlers.TerminateEventHandler;
import AFS.Interface.AFSRMIConnector;
import AFS.ServiceLayer.adminSessionManagement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * View vehicle information GUI (JFrame)
 * @author Malindu Ransara Nawarathne
 */
public class viewVehiclePerformance extends javax.swing.JFrame {

    /**
     * Creates new form viewVehiclePerformance
     */
    public viewVehiclePerformance() {
        //To prevent unauthorize access
        boolean statusCookie = false;
        statusCookie = adminSessionManagement.sessionValidate();
        if (statusCookie == false) {
            new adminLogin().setVisible(true);
            this.dispose();
        } else {
            initComponents();
            
            //To center the window in the display
            this.setLocationRelativeTo(null);
            
            //Initialising variables
            boolean loadStatus = false;
            String lstUpdate = "";
            
            //Creating AFSRMIConnector
            AFSRMIConnector generateChart = new AFSRMIConnector();
            
            //Analyze customer responses
            try {
                loadStatus = generateChart.afsconnector().analyseData();
            } catch (RemoteException ex) {
                Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (loadStatus == true) {
                //Generate chart
                try {
                    String charturl = "";
                    BufferedImage chartimg = null;
                    charturl = generateChart.afsconnector().createChart("bar", 7);
                    System.out.println("Chart URL: " + charturl);
                    /*
                2021. How to download Image from URL and save it in Java?. [online] Available at: <https://www.codercrunch.com/question/101501912/how-download-image-url-and-save-it-java>.
                     */
                    URL cUrl = new URL(charturl);
                    chartimg = ImageIO.read(cUrl);
                    ImageIO.write(chartimg, "png", new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart7.png"));
                    lstUpdate = lastUpdate();
                    /*
                Narros, T., Verma, N., z, m. and Zaki, A., 2021. Java: how to add image to Jlabel?. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/3775373/java-how-to-add-image-to-jlabel#:~:text=You%20have%20to%20supply%20to,thumb%20%3D%20new%20JLabel()%3B%20thumb.>.
                     */
                    ImageIcon chr = new ImageIcon("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart7.png");
                    lblChart.setIcon(chr);
                    lblLastUpdate.setText("Last Update: " + lstUpdate);
                    chr = null;
                } catch (RemoteException ex) {
                    Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failedd to analysed data!", "Error!", 2);
                lblLastUpdate.setText("Last Update: ");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblChart = new javax.swing.JLabel();
        comboBoxQNum = new javax.swing.JComboBox<>();
        btnGenerateChart = new javax.swing.JButton();
        lblLastUpdate = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        btnLogout3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        comboBoxQNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboBoxQNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Question 7", "Question 8", "Question 9", "Question 10" }));

        btnGenerateChart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGenerateChart.setText("Generate Chart");
        btnGenerateChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateChartActionPerformed(evt);
            }
        });

        lblLastUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLastUpdate.setText("Last Update: ");

        btnMainMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        btnLogout3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AFS/Resources/Logout.png"))); // NOI18N
        btnLogout3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogout3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLastUpdate)
                    .addComponent(lblChart, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBoxQNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGenerateChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLogout3))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboBoxQNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerateChart)
                        .addGap(18, 18, 18)
                        .addComponent(btnMainMenu)
                        .addGap(134, 134, 134)
                        .addComponent(btnLogout3))
                    .addComponent(lblChart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblLastUpdate)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(236, 124, 124));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aurora Tours Administrator Panel");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("-");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 718, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // To minimize the current window
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // Terminate event
        TerminateEventHandler te = new TerminateEventHandler();
        te.actionPerformed(null);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnGenerateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateChartActionPerformed
        // To generate chart according to the question number
        try {
            //Initialising variables
            String charturl = "";
            String questionNum = "";
            String lstUpdate = "";
            boolean analyseStatus = false;
            int qno = 0;
            BufferedImage chartimg = null;
            
            //Creating AFSRMIConnector object
            AFSRMIConnector generateChart = new AFSRMIConnector();
            analyseStatus = generateChart.afsconnector().analyseData();
            
            //Validaing analyzing process
            if (analyseStatus == true) {
                //Fetching last update
                lstUpdate = lastUpdate();
                questionNum = comboBoxQNum.getSelectedItem().toString();

                if (questionNum.compareTo("Question 7") == 0) {
                    qno = 7;
                } else if (questionNum.compareTo("Question 8") == 0) {
                    qno = 8;
                } else if (questionNum.compareTo("Question 9") == 0) {
                    qno = 9;
                } else if (questionNum.compareTo("Question 10") == 0) {
                    qno = 10;
                }
                
                //Generating Chart URL
                charturl = generateChart.afsconnector().createChart("bar", qno);
                System.out.println("Chart URL: " + charturl);
                /*
            2021. How to download Image from URL and save it in Java?. [online] Available at: <https://www.codercrunch.com/question/101501912/how-download-image-url-and-save-it-java>.
                 */
                //Downloading image to local folder
                URL cUrl = new URL(charturl);
                chartimg = ImageIO.read(cUrl);
                ImageIO.write(chartimg, "png", new File("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart" + qno + ".png"));
                
                /*
            Narros, T., Verma, N., z, m. and Zaki, A., 2021. Java: how to add image to Jlabel?. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/3775373/java-how-to-add-image-to-jlabel#:~:text=You%20have%20to%20supply%20to,thumb%20%3D%20new%20JLabel()%3B%20thumb.>.
                 */
                //Displaying downloaded chart
                ImageIcon chr = new ImageIcon("D:\\NetBeans Workspaces\\Aurora Feedback System\\AuroraFeedbackSystemClient\\src\\AFS\\Resources\\Charts\\afsChart" + qno + ".png");
                lblChart.setIcon(chr);
                lblLastUpdate.setText("Last Update: " + lstUpdate);
            } else {
                JOptionPane.showMessageDialog(this, "Failedd to analysed data!", "Error!", 2);
                lblLastUpdate.setText("Last Update: ");
            }

        } catch (RemoteException ex) {
            Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(viewDriverPerformance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateChartActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // To termiante the current window and to return to home window
        new adminHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnLogout3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout3MouseClicked
        // To Logout from the system
        adminSessionManagement.resetCookie();
        new adminLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogout3MouseClicked

    /**
     * Get last updated(analyzed) time and date 
     * @return the time and date
     */
    public String lastUpdate() {
        String cDate = "";
        Date currentDate = new Date();
        cDate = currentDate.toString();
        return cDate;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewVehiclePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewVehiclePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewVehiclePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewVehiclePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewVehiclePerformance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateChart;
    private javax.swing.JLabel btnLogout3;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JComboBox<String> comboBoxQNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblChart;
    private javax.swing.JLabel lblLastUpdate;
    // End of variables declaration//GEN-END:variables
}
