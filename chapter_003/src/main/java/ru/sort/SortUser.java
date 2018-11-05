package ru.sort;



import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> in) {
        Set<User> users = new TreeSet(in);
        return users;
    }

    public List<User> sortNameLength(List<User> in) {
      List<User> users = new ArrayList<>(in);
      users.sort(new Comparator<User>() {
                     @Override
                     public int compare(User o1, User o2) {
                         return Integer.compare(o1.name.length(), o2.name.length());
                     }
                 }
          );
      return users;
    }

    public List<User> sortByAllFields(List<User> in) {
        List<User> users = new ArrayList<>(in);

        users.sort(new Comparator<User>() {
            @Override
                public int compare(User o1, User o2) {
                    int result = o1.name.compareTo(o2.name);
                    if (result == 0) {
                        result = Integer.compare(o1.age, o2.age);
                    }
                    return result;
                }
        }
        );

        return users;
    }
}


