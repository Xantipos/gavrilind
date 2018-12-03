package ru.sort;
import org.junit.Test;


import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.TreeSet;
import java.util.Set;
import java.util.List;

public class SortDepTest {

    @Test
    public void list3departRevers() {
        String[] in = {"dd2/iddu", "dd3/iyyy", "dd3/iyyy/df3", "dd3/ieeee", "K1/SK1/SSK1"};
        SortingDep sort = new SortingDep();
        List<TreeSet> result = sort.addToDepart(in, 1);
        System.out.println(result.toString());
    }
    @Test
    public void list3departNormal() {
        String[] in = {"dd2/iddu", "dd3/iyyy", "dd3/iyyy/df3", "dd3/ieeee", "K1/SK1/SSK1"};
        SortingDep sort = new SortingDep();
        List<TreeSet> result = sort.addToDepart(in, 0);
        System.out.println(result.toString());
    }
}
