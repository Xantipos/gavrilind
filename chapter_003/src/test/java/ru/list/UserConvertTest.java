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
    public void List3Users() {
        UserConvert UserCon = new UserConvert();
        List<User> listus = new ArrayList<User>();
        User Dimon = new User("Dimon", "Nov", 2);
        User Kolyamba = new User("Kolyamba", "Nov", 3);
        User KsushaKot = new User("KsushaKot", "Nov", 6);

        listus.add(Dimon);
        listus.add(Kolyamba);
        listus.add(KsushaKot);

        HashMap map = new HashMap();
        map = UserCon.process(listus);

        HashMap expect = new HashMap();
        expect.put(2, "Dimon");

        assertThat(map.hashCode(), is(expect.hashCode()));
    }
}
