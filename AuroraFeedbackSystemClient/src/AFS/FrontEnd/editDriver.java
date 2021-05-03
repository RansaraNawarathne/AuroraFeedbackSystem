
package AFS.FrontEnd;

import AFS.FrontEnd.EventHandlers.TerminateEventHandler;
import AFS.Interface.AFSRMIConnector;
import AFS.Models.driver;
import AFS.ServiceLayer.adminSessionManagement;
import AFS.Utilities.AddressNullValueException;
import AFS.Utilities.AgeNullValueException;
import AFS.Utilities.AgeOutOfBoundException;
import AFS.Utilities.ConNullValueException;
import AFS.Utilities.EmailNullValueException;
import AFS.Utilities.NameNullValueException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Edit Driver Values GUI (JFrame)
 * @author ransa
 */
public class editDriver extends javax.swing.JFrame {

    /**
     * Creates new form editDriver
     */
    public editDriver() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnUpdateDrv = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSeaEmail = new javax.swing.JTextField();
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
        jLabel2.setText("Name: ");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age: ");

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email: ");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Number: ");

        txtContactNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address: ");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnUpdateDrv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdateDrv.setText("Update");
        btnUpdateDrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDrvActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email: ");

        txtSeaEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateDrv))
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAge, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSeaEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(333, 333, 333)
                .addComponent(btnLogout3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSeaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateDrv)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 789, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addContainerGap())
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
        // To minimize the current JFrame
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // Terminate event
        TerminateEventHandler te = new TerminateEventHandler();
        te.actionPerformed(null);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // To delete driver records
            String seaEmail = "";
            int SatIndex = 0;
            int SdotIndex = 0;
            boolean subStatus = false;

            //Fetching textfield values
            seaEmail = txtSeaEmail.getText();
            SatIndex = seaEmail.indexOf("@");
            SdotIndex = seaEmail.indexOf(".");

            //Validating fetched vlaues
            if ( ( seaEmail.trim().isEmpty() ) || ( SatIndex <= 0 ) || ( SdotIndex <= 0 ) ) {
                throw new EmailNullValueException();
            }

            //Creating AFSRMIConnector object
            AFSRMIConnector deleteDriver = new AFSRMIConnector();
            subStatus = deleteDriver.afsconnector().deleteDriver(seaEmail);

            //Verifying whether the data is deleted in the database
            if ( subStatus == true ) {
                System.out.println("Values are successfully send to the server....");
                JOptionPane.showMessageDialog(this, "Driver is successfully deleted!", "Status", 1);
                txtSeaEmail.setText("");
                txtName.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                txtContactNumber.setText("");
                txtAddress.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete Driver information!", "Error!", 2);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(editDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( EmailNullValueException ex1 ) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            // To search driver
            String seaEmail = "";
            int atIndex = 0;
            int dotIndex = 0;
            driver drv1 = null;

            //Fetching textfield valus
            seaEmail = txtSeaEmail.getText();
            atIndex = seaEmail.indexOf("@");
            dotIndex = seaEmail.indexOf(".");

            //Validating fetched values
            if ( (seaEmail.trim().isEmpty() ) || ( atIndex <= 0 ) || ( dotIndex <= 0 ) ) {
                throw new EmailNullValueException();
            }

            //Creting AFSRMIConnector object
            AFSRMIConnector driverManagement = new AFSRMIConnector();
            drv1 = driverManagement.afsconnector().searchdriver(seaEmail);

            // Displaying data which are fetched from the database
            if ( drv1 != null ) {
                txtName.setText(drv1.getName());
                txtEmail.setText(drv1.getEmail());
                txtAge.setText(drv1.getAge()+"");
                txtContactNumber.setText(drv1.getConNum()+"");
                txtAddress.setText(drv1.getAddress());
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid Email address!", "Error!", 2);
                txtSeaEmail.setText("");
                txtName.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                txtContactNumber.setText("");
                txtAddress.setText("");
            }

        } catch (RemoteException ex) {
            Logger.getLogger(editDriver.class.getName()).log(Level.SEVERE, null, ex);
        } catch ( NullPointerException ex1 ) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Email address!\n"+ex1.getLocalizedMessage(), "Error!", 2);
        } catch ( EmailNullValueException ex2 ) {
            JOptionPane.showMessageDialog(this, ex2.getLocalizedMessage(), "Error!", 2);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateDrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDrvActionPerformed
        // To update driver information
        try {
            String seaEmail = "";
            int atIndex = 0;
            int dotIndex = 0;
            int SatIndex = 0;
            int SdotIndex = 0;
            String name = "";
            String ageVal = "";
            String email = "";
            String conNumVal = "";
            String address = "";
            int age = 0;
            int conNum = 0;
            boolean subStatus = false;

            //Fetching textfield values
            seaEmail = txtSeaEmail.getText();
            name = txtName.getText();
            ageVal = txtAge.getText();
            email = txtEmail.getText();
            conNumVal = txtContactNumber.getText();
            address = txtAddress.getText();
            atIndex = email.indexOf("@");
            dotIndex = email.indexOf(".");
            SatIndex = seaEmail.indexOf("@");
            SdotIndex = seaEmail.indexOf(".");

            //Validating fethced textfield values
            if ( (seaEmail.trim().isEmpty() ) || ( SatIndex <= 0 ) || ( SdotIndex <= 0 ) ) {
                throw new EmailNullValueException();
            }
            if (name.trim().isEmpty()) {
                throw new NameNullValueException();
            }
            if (ageVal.trim().isEmpty()) {
                throw new AgeNullValueException();
            }
            age = Integer.parseInt(ageVal);
            if ((age <= 18) || (age > 60)) {
                throw new AgeOutOfBoundException();
            }
            if ( (email.trim().isEmpty() ) || ( atIndex <= 0 ) || ( dotIndex <= 0 ) ) {
                throw new EmailNullValueException();
            }
            if ((conNumVal.trim().isEmpty()) || (conNumVal.length() != 10) ) {
                throw new ConNullValueException();
            }
            conNum = Integer.parseInt(conNumVal);
            if ((address.trim().isEmpty()) || (address.length() < 10)) {
                throw new AddressNullValueException();
            }

            //Creating driver object
            driver drv2 = new driver(email, name, age, conNum, address);

            //Creating AFSRMIConnector object
            AFSRMIConnector updateDriver = new AFSRMIConnector();
            subStatus = updateDriver.afsconnector().updateDriver( seaEmail, drv2 );

            //Verifying whether the data is updated in the database
            if ( subStatus == true ) {
                System.out.println("Values are successfully send to the server....");
                JOptionPane.showMessageDialog(this, "Driver is successfully updated!", "Status", 1);
                txtSeaEmail.setText("");
                txtName.setText("");
                txtEmail.setText("");
                txtAge.setText("");
                txtContactNumber.setText("");
                txtAddress.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update Driver information!", "Error!", 2);
            }
        } catch (NameNullValueException ex1) {
            JOptionPane.showMessageDialog(this, ex1.getLocalizedMessage(), "Error!", 2);
        } catch (AgeNullValueException ex2) {
            JOptionPane.showMessageDialog(this, ex2.getLocalizedMessage(), "Error!", 2);
        } catch (EmailNullValueException ex3) {
            JOptionPane.showMessageDialog(this, ex3.getLocalizedMessage(), "Error!", 2);
        } catch (ConNullValueException ex4) {
            JOptionPane.showMessageDialog(this, ex4.getLocalizedMessage(), "Error!", 2);
        } catch (AddressNullValueException ex5) {
            JOptionPane.showMessageDialog(this, ex5.getLocalizedMessage(), "Error!", 2);
        } catch (AgeOutOfBoundException ex6) {
            JOptionPane.showMessageDialog(this, ex6.getLocalizedMessage(), "Error!", 2);
        } catch (NumberFormatException ex7) {
            JOptionPane.showMessageDialog(this, "Please enter valid data into the age field!", "Error!", 2);
        } catch (RemoteException ex) {
            Logger.getLogger(editDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateDrvActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // Terminate current window and retruning to the home window
        //btnCancel.addActionListener(new TerminateEventHandler());
        new adminHome().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(editDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel btnLogout3;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateDrv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSeaEmail;
    // End of variables declaration//GEN-END:variables
}
