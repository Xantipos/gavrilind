package ru.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int[] i : array) {
            list = Arrays.stream(i).boxed().collect(Collectors.toList());
        }
        return list;
    }
}
