package ru.bank;

public class User {
    public String name;
    public String passport;

    public User() {
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;

    }
    public String getName() {
        return this.name;
    }
    public String getPassport() {
        return this.passport;
    }
}
