//Driver modal class
package AFS.Models;

import java.io.Serializable;

public class driver implements Serializable {
    private String email;
    private String name;
    private int age;
    private int conNum;
    private String Address;

    public driver(String email, String name, int age, int conNum, String Address) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.conNum = conNum;
        this.Address = Address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getConNum() {
        return conNum;
    }

    public String getAddress() {
        return Address;
    }
    
    
}
