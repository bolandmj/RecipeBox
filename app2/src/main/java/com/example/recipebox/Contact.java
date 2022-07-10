package com.example.recipebox;


//java class database
//users information
public class Contact {
    int id;
    String name;
    String phone_number;

    public Contact(String name, String phone_number){

        this.phone_number=phone_number;
    }

    public Contact(int id, String name, String phone_number){
        this.id=id;
        this.name=name;
        this.phone_number=phone_number;
    }




    public void setId(int id) {

        this.id = id;

    }

    public void setName(String name) {

        this.name = name;

    }
    public void setPhone_number(String phone_number) {

        this.phone_number = phone_number;

    }




    public int getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getPhone_number() {

        return phone_number;

    }



}
