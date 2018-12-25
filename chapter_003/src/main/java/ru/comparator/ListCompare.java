package ru.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;

        List<String> tasks = Arrays.asList(left, right);
        String top = tasks.stream().max(String::compareTo).get();
        if (top.equals(left) && !right.equals(left)) {
            result = 1;
        }
        if (top.equals(right) && !right.equals(left)) {
            result = -1;
        }
        return result;
    }
}
