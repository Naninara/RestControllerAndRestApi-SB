package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    List<UserData> db = new ArrayList<>();

    public UserDataBase() {
        db.add(new UserData(1,"mavin",20));
        db.add(new UserData(2,"manikanta",30));
    }
    public List<UserData> getAllUsers(){
        return this.db;
    }
    public UserData getOneUser(int id){
        for(UserData user:db){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public UserData AddUser(UserData user){
        db.add(user);
        return user;
    }

    public  boolean DeleteUser(int id){
        for(UserData user : db){
            if(user.getId()==id){
                db.remove(user);
                return true;
            }
        }
        return false;
    }
}
