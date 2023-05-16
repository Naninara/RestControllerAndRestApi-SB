package com.example.demo;

public class UserData {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public UserData(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
