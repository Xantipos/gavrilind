package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //�������� ����� ����, ����������� ���������� ������� �� 10 ��������� ������� ��������, �������� {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
 BubbleSort sorting = new BubbleSort();

        int[] result;
        int[] data = {2, 1, 5, 6, 4, 7, 8, 9, 0, 3};
        int[] out = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        result = sorting.sort(data);


        assertThat(result, is(out));

    }
}





