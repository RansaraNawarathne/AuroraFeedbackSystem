
package AFS.FrontEnd;

import AFS.FrontEnd.EventHandlers.TerminateEventHandler;
import AFS.Interface.AFSRMIConnector;
import AFS.Models.reservation;
import AFS.ServiceLayer.adminSessionManagement;
import AFS.Utilities.EmailNullValueException;
import AFS.Utilities.VehicleNumberNullException;
import AFS.Utilities.invoiceNullValueException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Edit Reservation GUI (JFrame)
 * @author Malindu Ransara Nawarathne
 */
public class editReservation extends javax.swing.JFrame {

    /**
     * Creates new form editReservation
     */
    
    public editReservation() {
        //To prevent unauthorize access
        boolean statusCookie = false;
        statusCookie = adminSessionManagement.sessionValidate();
        if ( statusCookie == false ) {
            new adminLogin().setVisible(true);
            this.dispose();
        } else {
            initComponents();
            //To center the window in the display
            this.setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblInvNum = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDrvID = new javax.swing.JTextField();
        txtVehID = new javax.swing.JTextField();
        txtSeaInvNo = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLogout3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(53, 58, 64));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Invoice Number: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Driver ID: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vehicle ID: ");

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblInvNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInvNum.setForeground(new java.awt.Color(255, 255, 255));
        lblInvNum.setText("afs");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Invoice Number: ");

        txtDrvID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtVehID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSeaInvNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblInvNum)
                            .addComponent(txtDrvID)
                            .addComponent(txtVehID)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSeaInvNo, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)))))
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSeaInvNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblInvNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDrvID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVehID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnLogout3)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 653, Short.MAX_VALUE)
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
        // Minimize event
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // Terminate event
        TerminateEventHandler te = new TerminateEventHandler();
        te.actionPerformed(null);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // To close the current window and to return to home window
        //btnCancel.addActionListener(new TerminateEventHandler());
        new adminHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // To update reservation information
        try {
            //Initializing and declaring variables
            String seaInvNum = "";
            String invID = "";
            String drvID = "";
            String vehID = "";
            reservation resv1 = null;
            String baseVal = "";

            //Fetchiing textfield values
            seaInvNum = txtSeaInvNo.getText();
            invID = lblInvNum.getText();
            drvID = txtDrvID.getText();
            vehID = txtVehID.getText();

            //Validating fetched values
            if ( seaInvNum.trim().isEmpty() ) {
                throw new invoiceNullValueException();
            }
            baseVal = seaInvNum.substring(0, 3);
            if (baseVal.compareTo("afs") != 0) {
                throw new invoiceNullValueException();
            }
            if (invID.trim().isEmpty()) {
                throw new invoiceNullValueException();
            }
            if (drvID.trim().isEmpty()) {
                throw new EmailNullValueException();
            }
            if (vehID.trim().isEmpty()) {
                throw new VehicleNumberNullException();
            }

            //Creating reservation object
            resv1 = new reservation(invID, drvID, vehID);

            //creating AFSRMIConnector object
            AFSRMIConnector ansSet1 = new AFSRMIConnector();
            boolean SubStatus = false;
            SubStatus = ansSet1.afsconnector().updateReservation(seaInvNum, resv1);

            //Validting whether the values are successfully updated or not
            if (SubStatus == true) {
                System.out.println("Values are successfully send to the server....");
                JOptionPane.showMessageDialog(this, "Reservation is successfully updated!", "Status", 1);
                
                txtSeaInvNo.setText("");
                lblInvNum.setText("afs");
                txtDrvID.setText("");
                txtVehID.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update reservation!", "Error!", 2);
            }
        } catch (invoiceNullValueException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        } catch (EmailNullValueException ex2) {
            JOptionPane.showMessageDialog(this, ex2.getLocalizedMessage(), "Error!", 2);
        } catch (VehicleNumberNullException ex3) {
            JOptionPane.showMessageDialog(this, ex3.getLocalizedMessage(), "Error!", 2);
        } catch (RemoteException ex) {
            Logger.getLogger(addNewReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       // To search reservation:
        try { 
            //Initializing and declaring variables and objects
            String seaInvNum = "";
            reservation resv2 = null;
            String baseVal = "";
            
            //Fetching textfield values
            seaInvNum = txtSeaInvNo.getText();
            
            //Validating fetched values
            if ( seaInvNum.trim().isEmpty() ) {
                throw new invoiceNullValueException();
            }
            baseVal = seaInvNum.substring(0, 3);
            if (baseVal.compareTo("afs") != 0) {
                throw new invoiceNullValueException();
            }
            
            //Creating AFSRMIConnector object
            AFSRMIConnector reservationManagement = new AFSRMIConnector();
            resv2 = reservationManagement.afsconnector().searchReservation( seaInvNum );
            
            //Validating fetched fetched reservation object is null
            if ( resv2 != null ) {
                lblInvNum.setText(resv2.getInvID());
                txtDrvID.setText(resv2.getDrvID());
                txtVehID.setText(resv2.getVehID());
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid invoice number!", "Error!", 2);
                lblInvNum.setText("");
                txtDrvID.setText("");
                txtVehID.setText("");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(editReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (invoiceNullValueException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // To delete reservation info
        try {
            //Initializing and declaring variables
            String seaInvNum = "";
            boolean subStatus = false;
            String baseVal = "";
            
            //Fetching textfield values
            seaInvNum = txtSeaInvNo.getText();
            
            //Validating fetched values
            if ( seaInvNum.trim().isEmpty() ) {
                throw new invoiceNullValueException();
            }
            baseVal = seaInvNum.substring(0, 3);
            if (baseVal.compareTo("afs") != 0) {
                throw new invoiceNullValueException();
            }
            
            //Creating AFSRMIConnector
            AFSRMIConnector deleteReservation = new AFSRMIConnector();
            subStatus = deleteReservation.afsconnector().deleteReservation( seaInvNum );
            
            //Verifying whther the data is deleted in the database
            if ( subStatus == true ) {
                System.out.println("Values are successfully send to the server....");
                JOptionPane.showMessageDialog(this, "Reservation is successfully deleted!", "Status", 1);
                
                txtSeaInvNo.setText("");
                lblInvNum.setText("afs");
                txtDrvID.setText("");
                txtVehID.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete reservation!", "Error!", 2);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(editReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (invoiceNullValueException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLogout3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout3MouseClicked
        // To Logout from the system
        adminSessionManagement.resetCookie();
        new adminLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogout3MouseClicked

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
            java.util.logging.Logger.getLogger(editReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel btnLogout3;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblInvNum;
    private javax.swing.JTextField txtDrvID;
    private javax.swing.JTextField txtSeaInvNo;
    private javax.swing.JTextField txtVehID;
    // End of variables declaration//GEN-END:variables
}
