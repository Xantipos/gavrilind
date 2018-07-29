package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void when2then14() {
    //???????? ?????? counter ??? ????????

        Square array = new Square();
        int[] result;

            result = Square.calculate(4);
            assertThat(result[0], is(1));
           assertThat(result[1], is(1));
           assertThat(result[2], is(4));
          assertThat(result[3], is(9));

    }
}