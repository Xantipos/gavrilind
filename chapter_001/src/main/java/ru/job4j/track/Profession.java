package ru.job4j.track;

public class Profession {
    public static String name;
    public String profession;

    public Profession(){
    }

    public Profession(String name, String profession){
        this.name = name;
        this.profession=profession;
    }
    public String getname(){
        return this.name;
    }
    public String getpro(){
        return this.profession;
    }

}


