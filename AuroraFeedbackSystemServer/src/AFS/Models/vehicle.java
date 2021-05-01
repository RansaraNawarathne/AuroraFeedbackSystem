/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Models;

import java.io.Serializable;

/**
 * Vehicle model class
 * @author Malindur ransara Nawarathne
 */
public class vehicle implements Serializable{
    private String vehNumber;
    private String vehBrand;
    private String yom;
    private String name;
    private String email;
    private int conNum;
    private String address;

   /**
     * Constructor: Create a vehicle object
     * @param vehNumber: Vehicle plate number
     * @param vehBrand: Brand of the vehicle
     * @param yom: Year of manufacture of the vehicle
     * @param name: Name of the vehicle owner
     * @param email: Email address of the vehicle owner
     * @param conNum: Contact number of the vehicle owner
     * @param address: Address of the vehicle owner
     */
    public vehicle(String vehNumber, String vehBrand, String yom, String name, String email, int conNum, String address) {
        this.vehNumber = vehNumber;
        this.vehBrand = vehBrand;
        this.yom = yom;
        this.name = name;
        this.email = email;
        this.conNum = conNum;
        this.address = address;
    }

    /**
     * Get the vehicle number
     * @return the vehicle number
     */
    public String getVehNumber() {
        return vehNumber;
    }

    /**
     * Get the vehicle brand
     * @return the vehicle brand
     */
    public String getVehBrand() {
        return vehBrand;
    }

    /**
     * Get the year of manufacture of the vehicle
     * @return year of manufacture of the vehicle
     */
    public String getYom() {
        return yom;
    }

    /**
     * Get the name of the owner
     * @return name of the owner
     */
    public String getName() {
        return name;
    }

    /**
     * Get the email address of the user
     * @return email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the contact number of the owner
     * @return contact number of the owner
     */
    public int getConNum() {
        return conNum;
    }

    /**
     * Get the address of the owner
     * @return address of the owner
     */
    public String getAddress() {
        return address;
    }
    
    
}
