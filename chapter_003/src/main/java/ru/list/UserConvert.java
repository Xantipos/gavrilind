package ru.list;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap users = new HashMap();
           users.put(list.stream().map((user) -> user.getId()).collect(Collectors.toList()), list.stream().toArray());
        return users;
    }
}
