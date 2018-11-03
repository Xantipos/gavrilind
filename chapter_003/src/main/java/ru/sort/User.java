package ru.sort;

public class User implements Comparable<User> {
    public Integer age;
    public String name;

    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public Integer getAge() {
        return this.age;
    }
}
