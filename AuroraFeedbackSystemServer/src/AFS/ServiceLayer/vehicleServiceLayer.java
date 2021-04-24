//Vehicle Service Layer
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.ServiceLayer;

import AFS.DatabaseLayer.DatabaseConnection;
import AFS.Models.vehicle;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ransa
 */
public class vehicleServiceLayer {
    private static Connection conn;
    private static PreparedStatement prst;
    private static Statement state;
    private static ResultSetImpl rsts;
    
    public boolean saveVehicle ( vehicle veh ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("INSERT INTO `vehicle` (`vehNumber`, `vehBrand`, `vehYom`, `ownerName`, `ownerEmail`, `ownerConNum`, `ownerAddress`) VALUES ('"+veh.getVehNumber()+"', '"+veh.getVehBrand()+"', '"+veh.getYom()+"', '"+veh.getName()+"', '"+veh.getEmail()+"', '"+veh.getConNum()+"', '"+veh.getAddress()+"');");
            
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public vehicle searchVehicle ( String seaVehNum ) {
        try {
            vehicle veh1 = null;
            conn = DatabaseConnection.getInstance().getConnection();
            state = (Statement) conn.createStatement();
            rsts = (ResultSetImpl) state.executeQuery("SELECT * FROM `vehicle` WHERE `vehNumber` = '"+seaVehNum+"';");
            
            while ( rsts.next() ) {
                veh1 = new vehicle(rsts.getString(1), rsts.getString(2), rsts.getString(3), rsts.getString(4), rsts.getString(5), rsts.getInt(6), rsts.getString(7));
            }
            return veh1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean editVehicle ( String seaVehNum, vehicle veh2 ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("UPDATE `vehicle` SET `vehNumber`='"+veh2.getVehNumber()+"',`vehBrand`='"+veh2.getVehBrand()+"',`vehYom`='"+veh2.getYom()+"',`ownerName`='"+veh2.getName()+"',`ownerEmail`='"+veh2.getEmail()+"',`ownerConNum`='"+veh2.getConNum()+"',`ownerAddress`='"+veh2.getAddress()+"' WHERE `vehNumber` = '"+veh2.getVehNumber()+"';");
            
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteDriver ( String seaVehNum ) {
        try {
            boolean statusRes = false;
            conn = DatabaseConnection.getInstance().getConnection();
            prst = (PreparedStatement) conn.prepareStatement("DELETE FROM `vehicle` WHERE `vehNumber` = '"+seaVehNum+"';");
            
            if ( prst.executeUpdate() > 0 ) {
                statusRes = true;
            }
            
            return statusRes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(vehicleServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
