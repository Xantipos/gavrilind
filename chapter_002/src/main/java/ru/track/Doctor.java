package ru.track;

public class Doctor extends Profession {

    public Doctor(String name, String profession) {
        super(name, profession);
        super.name = null;
    }
    public String heal(Patient patient) {
        return new Diagnose("Желтуха");
    }
}
