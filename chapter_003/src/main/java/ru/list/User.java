package ru.list;

public class User {

    public Integer id;
    public String name;
    public String city;

    public User() {
    }

    public User(String name, String city, Integer id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public String getCity() {
        return this.city;
    }
    public Integer getId() {
        return this.id;
    }

}
