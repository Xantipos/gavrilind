package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {

Factorial fact = new Factorial();
int result;
result = fact.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //�������� ����� ����, �����������, ��� ��������� ��� ����� 0 ����� 1.
Factorial fact = new Factorial();
int result;
result = fact.calc(0);
        assertThat(result, is(1));
    }
}