package ru.list;
import java.util.List;
import java.util.HashMap;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap UserS=new HashMap();
        for (User  us : list) {
            UserS.put(us.getId(), us);
        }
        return UserS;
    }
}
