package ru.list;
import java.util.List;
import java.util.HashMap;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap users = new HashMap();
        for (User  us : list) {
            users.put(us.getId(), us);
        }
        return users;
    }
}
