
package AFS.Models;

public class vehicle {
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
