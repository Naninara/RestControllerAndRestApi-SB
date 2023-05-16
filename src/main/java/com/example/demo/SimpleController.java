package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleController {
    UserDataBase db = new UserDataBase();
    @GetMapping("/hi")
    public String sayHi(){
        return "Voilaa we runned our api";
    }

    //https:localhost:8080/search?q=mavin   ------> it is called the query param
    @GetMapping("/search")
    public String searchApi(@RequestParam String q){
        DataBase db = new DataBase();
        return db.check(q);
    }

    @GetMapping("/users")
    public List getAllUsers(){
        return db.getAllUsers();
    }

    //https:localhost:8080/users/mavin -------------> /mavin  is the path parameter given to the user
    @GetMapping("/users/{id}")
    public ResponseEntity<UserData> getOneUser(@PathVariable int id){
        UserData body =  db.getOneUser(id);
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        List<String> li = new ArrayList<>();
        li.add("mavin");
        li.add("manikanta");
        headers.put("server",li);
        HttpStatus status = HttpStatus.FOUND;
        ResponseEntity<UserData> response = new ResponseEntity<>(body,headers,status);
        return response;

    }

    //older version of writing apis
    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "helloooooooooooo";
    }


    //Post Api

    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserData addUser(@RequestBody UserData user){
        return db.AddUser(user);
    }

    //delete api

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable int id){
        return db.DeleteUser(id);
    }
}
