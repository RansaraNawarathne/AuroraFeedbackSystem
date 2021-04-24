/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFS.Models;

import java.io.Serializable;

/**
 *
 * @author ransa
 */
public class vehicle implements Serializable{
    private String vehNumber;
    private String vehBrand;
    private String yom;
    private String name;
    private String email;
    private int conNum;
    private String address;

    public vehicle(String vehNumber, String vehBrand, String yom, String name, String email, int conNum, String address) {
        this.vehNumber = vehNumber;
        this.vehBrand = vehBrand;
        this.yom = yom;
        this.name = name;
        this.email = email;
        this.conNum = conNum;
        this.address = address;
    }

    public String getVehNumber() {
        return vehNumber;
    }

    public String getVehBrand() {
        return vehBrand;
    }

    public String getYom() {
        return yom;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getConNum() {
        return conNum;
    }

    public String getAddress() {
        return address;
    }
    
    
}
