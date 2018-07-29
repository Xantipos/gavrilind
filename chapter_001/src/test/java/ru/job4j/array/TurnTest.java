package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        //�������� ����� ����, ����������� ��������� ������� � ������ ������ ���������, �������� {2, 6, 1, 4}.
        Turn array = new Turn();
        int[] result;
        int[] data = {1, 2, 3, 4, 5, 6};
        int[] out = {6, 5, 4, 3, 2, 1};
            result = Turn.back(data);
        assertThat(result, is(out));
    }

  //  @Test
  //  public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //�������� ����� ����, ����������� ��������� ������� � �������� ������ ���������, �������� {1, 2, 3, 4, 5}.
  //  }
}