package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoSortTest {
    @Test
    public void sortintwoaarayinone() {

        int[] result;
        int[] data1 = {2, 4, 6, 8, 10, 12};
        int[] data2 = {1, 3, 5, 7, 9, 11};
        int[] out = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        result = TwoSort.sort(data1, data2);
        assertThat(result, is(out));
    }

    @Test
    public void sortbigandsmall() {

        int[] result;
        int[] data1 = {2, 4, 6, 8};
        int[] data2 = {1, 3, 5, 7, 9, 11};
        int[] out = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        result = TwoSort.sort(data1, data2);
        assertThat(result, is(out));
    }

    @Test
    public void sortbigandsmall2() {

        int[] result;
        int[] data1 = {2, 4, 6, 8, 11, 13};
        int[] data2 = {1, 3, 5, 7};
        int[] out = {1, 2, 3, 4, 5, 6, 7, 8, 11, 13};
        result = TwoSort.sort(data1, data2);
        assertThat(result, is(out));
    }
} 