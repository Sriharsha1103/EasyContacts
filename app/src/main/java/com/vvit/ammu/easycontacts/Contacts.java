package com.vvit.ammu.easycontacts;

/**
 * Created by Ammu on 02-05-2017.
 */

public class Contacts {
    private String name,email,address;
    private String phone;


    public Contacts(){
    }
    public Contacts(String name, String email, String address, String phone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    public Contacts(String name, String phone){
        this.name = name;

        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
