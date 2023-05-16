package com.example.demo;

import java.util.HashMap;

public class DataBase {
    private HashMap<String,String> details = new HashMap<>();
    public DataBase(){
        details.put("mavin","userName:Mavin");
        details.put("Nani","userName:Nani");
    }
    public String check(String query){
        if(details.containsKey(query)){
            return details.get(query);
        }
        return "No user Found";
    }
}
