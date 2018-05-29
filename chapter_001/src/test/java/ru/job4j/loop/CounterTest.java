package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
    //создадим объект counter для проверки


Counter cont = new Counter();
int result;
result=cont.add(0,10);
        assertThat(result, is(30));
    }
}