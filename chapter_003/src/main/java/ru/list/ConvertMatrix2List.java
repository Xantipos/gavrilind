package ru.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        return Arrays.stream(array).flatMapToInt(IntStream::of).boxed()
                .collect(Collectors.toList());
    }
}
