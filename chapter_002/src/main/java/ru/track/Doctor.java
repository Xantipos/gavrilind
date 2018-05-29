package ru.track;

public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        this.name = "House M.D.";
        this.profession = "Doctor";
    }
    String diagnose;
    public String heal() {
        return diagnose;
    }
}