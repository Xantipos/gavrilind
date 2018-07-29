package ru.track;

public class Doctor extends Profession {

    public Doctor(String name, String profession) {
        super(name, profession);
    }

    public String heal() {
        return "bobo";
    }
}