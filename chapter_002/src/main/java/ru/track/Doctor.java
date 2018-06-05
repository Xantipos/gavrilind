package ru.track;

public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        super.name = "House M.D.";
        super.profession = "Doctor";
        String disease = "h1n1";
    }
    String diagnose = "healthy";
    public String heal(String disease) {

        return diagnose;
    }
}