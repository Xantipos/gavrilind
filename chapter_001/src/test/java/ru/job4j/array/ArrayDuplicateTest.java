package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {


ArrayDuplicate delet = new ArrayDuplicate();
String[] arr = new String[] {"Privet", "Mir", "Privet", "Super", "Mir"};
String[] out = new String[] {"Privet", "Mir", "Super"};
String[] result = delet.remove(arr);

 assertThat(result, is(out));

    }
}