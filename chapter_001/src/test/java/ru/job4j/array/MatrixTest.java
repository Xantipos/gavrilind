package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        Matrix matr = new Matrix();
        int[][] result;
        int[][] out = {
                {0, 1, 2},
                {1, 1, 2},
                {2, 2, 4}
        };
        result = matr.multiple(3);
        assertThat(result, is(out));
    }
}





