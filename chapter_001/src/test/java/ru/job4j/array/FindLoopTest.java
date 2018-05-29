package ru.job4j.array;



import org.junit.Test;


import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;



public class FindLoopTest {
    @Test
    public void when2then14() {

        FindLoop find = new FindLoop();

        int result;
        int data[] = {0, 1, 2, 3, 4, 5, 6, 8, 8, 9};

        result = find.indexOf(data, 7);


        assertThat(result, is(8));

    }
}