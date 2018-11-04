package ru.sort;



import java.util.*;

public class SortUser {

    public Set<User> sort (List<User> in) {
        Set<User> users = new TreeSet(in);
        return users;
    }

    public List<User> sortNameLength (List<User> in){
      List<User> users = new ArrayList<>(in);
      users.sort(new Comparator<User>() {
                     @Override
                     public int compare(User o1, User o2) {
                         return String.valueOf(o1.name.length()).compareTo(String.valueOf(o2.name.length()));
                     }
                 }
          );
      return users;
    }

    public List<User> sortByAllFields (List<User> in) {
        List<User> users = new ArrayList<>(in);

        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
               int result = 0;
                int resname = o1.name.compareTo(o2.name) ;
               int resage = String.valueOf(o1.age).compareTo(String.valueOf(o2.age));
                if((resname == 1 & resage == 1) | (resname == 0 & resage ==1) | (resname == 1 & resage == 0)) {
                    result = 1;
                } else if ((resname == -1 & resage == -1) | (resname == 0 & resage == -1) | (resname == -1 & resage == 0) ) {
                    result = -1;
                }

                return result;
            }
        }
        );

        return users;
    }
}


