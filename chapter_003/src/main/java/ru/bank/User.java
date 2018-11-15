package ru.bank;

public class User implements Comparable<User> {
    public String name;
    public String passport;

    @Override
    public int compareTo(ru.bank.User o) {
        return this.passport.compareTo(o.passport);
    }

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
