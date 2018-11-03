package ru.sort;



import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Set;

public class SortUser {

    public Set<User> sort (List<User> in) {
        Set<User> users = new TreeSet<User>();
        users.addAll(in);
        return users;

    }
}


