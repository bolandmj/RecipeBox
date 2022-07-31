package com.example.recipebox;


//java class database
//users information
public class Contact {
    int id;
    String name;
    String phoneNumber;

    public Contact(){

        this.phoneNumber = phoneNumber;
    }

    public Contact(int id, String name, String phoneNumber){
        this.id=id;
        this.name=name;
        this.phoneNumber =phoneNumber;
    }




    public void setId(int id) {

        this.id = id;

    }

    public void setName(String name) {

        this.name = name;

    }
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;

    }




    public int getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getPhoneNumber() {

        return phoneNumber;

    }



}
