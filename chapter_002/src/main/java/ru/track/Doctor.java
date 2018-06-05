package ru.track;

public class Doctor extends Profession {
    public Doctor(String name, String profession) {
        super.name = "House M.D.";
        super.profession = "Doctor";
    }

    public String heal(Patient patient) {
        return new Diagnose("Желтуха");
    }
}