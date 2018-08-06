package ru.tracker.model;

public class Item {
    public String id;

    public String name;

    public String description;

    public long create;

    public Item() {
    }


    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;

    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }
    public String getId() {
        return this.id;
    }

    public String GetDone(){
        String done = new StringBuilder()

                .append("------------ New Item with Id : " + getId())
                .append(System.lineSeparator())
                .append("------------ New Item with Name : " + getName())
                .append(System.lineSeparator())
                .append("------------ New Item with Name : " + getDescription())
                .toString();
        return done;}

    public void setId(String id) {
        this.id = id;
    }


}