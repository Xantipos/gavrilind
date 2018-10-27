package ru.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.List;
import java.util.HashMap;

public class UserConvertTest {
    @Test
    public void list3users() {
        UserConvert usercon = new UserConvert();
        List<User> listus = new ArrayList<User>();
        User dimon = new User("Dimon", "Nov", 2);
        User kolyamba = new User("Kolyamba", "Nov", 3);
        User ksushaKot = new User("KsushaKot", "Nov", 6);

        listus.add(dimon);
        listus.add(kolyamba);
        listus.add(ksushaKot);

        HashMap map = new HashMap();
        map = usercon.process(listus);

        HashMap expect = new HashMap();
        expect.put(2, "Dimon");

        assertThat(map.hashCode(), is(expect.hashCode()));
    }
}
