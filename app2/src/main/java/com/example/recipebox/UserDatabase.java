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


}
