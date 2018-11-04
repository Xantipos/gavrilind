package ru.sort;
import org.junit.Test;


import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.TreeSet;
import java.util.Set;
import java.util.List;



public class SortUserTest {
    @Test
    public void list3users() {
        SortUser usersort = new SortUser();
        List<ru.sort.User> listus = new ArrayList<ru.sort.User>();
        ru.sort.User dimon = new ru.sort.User("Dimon", 29);
        ru.sort.User kolyamba = new ru.sort.User("Kolyamba", 28);
        ru.sort.User ksushaKot = new ru.sort.User("ksushaKot", 27);

        listus.add(dimon);
        listus.add(kolyamba);
        listus.add(ksushaKot);

        Set<User> result = usersort.sort(listus);


        Set<User> expect = new TreeSet<User>();
        expect.add(ksushaKot);
        expect.add(kolyamba);
        expect.add(dimon);
        assertThat(result, is(expect));
    }

    @Test
    public void doublefieldtest() {
        SortUser usersort = new SortUser();
        List<ru.sort.User> listus = new ArrayList<ru.sort.User>();
        ru.sort.User dimon = new ru.sort.User("Dimon", 29);
        ru.sort.User dimon1 = new ru.sort.User("Dimon", 32);
        ru.sort.User kolyamba = new ru.sort.User("Kolyamba", 28);
        ru.sort.User kolyamba1 = new ru.sort.User("Kolyamba", 35);
        ru.sort.User ksushaKot = new ru.sort.User("ksushaKot", 27);

        listus.add(dimon);
        listus.add(dimon1);
        listus.add(kolyamba);
        listus.add(kolyamba1);
        listus.add(ksushaKot);

        List<User> result = usersort.sortByAllFields(listus);


        List<User> expect = new ArrayList<>();
        expect.add(dimon);
        expect.add(dimon1);
        expect.add(kolyamba);
        expect.add(kolyamba1);
        expect.add(ksushaKot);

        for (User us : result) {
            System.out.print(us.name  );
            System.out.println(us.age);
        }
        assertThat(result, is(expect));
    }
}

