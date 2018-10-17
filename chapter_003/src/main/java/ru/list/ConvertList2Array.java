package ru.list;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {

        int ost = list.size() % rows > 0? 1 : 0;
        int cells = list.size()/rows + ost;
        int[][] array = new int[rows][cells];

        int conter = 0;
        for (int j = 0; j != cells; j++) {
            for (int i = 0; i != rows; i++) {
                conter = (i + j) + 2 * j;
                if (conter < list.size()) {
                    array[j][i] = list.get(conter);
                } else break;
            }
        }
        return array;
    }
}

