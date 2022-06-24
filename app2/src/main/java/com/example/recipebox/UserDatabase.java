package com.example.recipebox;


//java class database
//users information
public class UserDatabase {
    int ID;
    String Name;
    String PhoneNumber;

    public UserDatabase(String Name, String PhoneNumber){
      this.PhoneNumber=PhoneNumber;
    }
    public UserDatabase(int ID,String Name, String PhoneNumber){
        this.ID=ID;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
    }

    public void setID(int ID) {

        this.ID = ID;

    }

    public void setName(String name) {

        Name = name;

    }
    public void setPhoneNumber(String phoneNumber) {

        PhoneNumber = phoneNumber;

    }




    public int getID() {

        return ID;

    }

    public String getName() {

        return Name;

    }

    public String getPhoneNumber() {

        return PhoneNumber;

    }



}
