
package AFS.Models;

import java.io.Serializable;

/**
 * Driver model class
 * @author Malindu Ransara Nawarathne
 */
public class driver implements Serializable {
    private String email;
    private String name;
    private int age;
    private int conNum;
    private String Address;

    /**
     * Constructor: Create a driver Object
     * @param email: Email address of the driver
     * @param name: Name of the driver
     * @param age: Age of the driver
     * @param conNum: Contact number of the driver
     * @param Address: Address of the driver
     */
    public driver(String email, String name, int age, int conNum, String Address) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.conNum = conNum;
        this.Address = Address;
    }

    /**
     * Get the email address of the driver
     * @return email address of the driver
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the name of the driver
     * @return name of the driver
     */
    public String getName() {
        return name;
    }

    /**
     * Get the age of the driver
     * @return age of the driver
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the contact number of the driver
     * @return contact number of the driver
     */
    public int getConNum() {
        return conNum;
    }

    /**
     * Get the address of the driver
     * @return address of the driver
     */
    public String getAddress() {
        return Address;
    }
    
    
}
