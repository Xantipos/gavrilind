package ru.list;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {

        int ost = list.size() % rows > 0? 1 : 0;
        int cells = list.size()/rows + ost;
        int[][] array = new int[rows][cells];
        List<Integer> clone = new ArrayList<Integer>(list.size());
        for (Integer item : list) clone.add(item);

        for (int k = 0; k != rows * cells - list.size(); k++) {clone.add(0);}

        int conter = 0;
        for (int j = 0; j != cells; j++) {
            for (int i = 0; i != rows; i++) {
                conter = (i + j) + 2 * j;
                array[j][i] = clone.get(conter);
            }
        }
        return array;
    }
}

