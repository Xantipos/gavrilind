package ru.sort;
import org.junit.Test;


import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.TreeSet;
import java.util.Set;
import java.util.List;

public class SortdepartTest {

    @Test
    public void list3departRevers() {
        String[] in = {"dd2", "dd1", "dd3", "dd2/iddu", "dd3/iyyy", "dd3/iyyy/df3", "dd3/ieeee"};
        Sortdepart sort = new Sortdepart();
        List<TreeSet> res2 = sort.addToDepart(in,1);
        System.out.println(res2.toString());

    }
    @Test
    public void list3departNormal() {
        String[] in = {"dd2", "dd1", "dd3", "dd2/iddu", "dd3/iyyy"};
        Sortdepart sort = new Sortdepart();
        List<TreeSet> res2 = sort.addToDepart(in,0);
        System.out.println(res2.toString());
    }
}
