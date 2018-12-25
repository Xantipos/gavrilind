package ru.list;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int ost = list.size() % rows > 0 ? 1 : 0;
        int cells = list.size() / rows + ost;
        int[][] array = new int[rows][cells];

        int[] res = new int[rows];
        List<Integer> rt = list.stream().limit(rows).collect(Collectors.toList());

        int[] intArray = Arrays.stream(rt.toArray(new Integer[rows])).mapToInt(Integer::intValue).toArray();

        List<Integer> rt2 = list.stream().skip(rows).limit(rows).collect(Collectors.toList());

        int[] intArray2 = Arrays.stream(rt2.toArray(new Integer[rows])).mapToInt(Integer::intValue).toArray();

        List<Integer> rt3 = list.stream().skip(rows * 2).limit(rows).collect(Collectors.toList());
        int[] intArray3 = Arrays.stream(rt3.toArray(new Integer[rt3.size()])).mapToInt(Integer::intValue).toArray();

        System.arraycopy(intArray, 0, array[0], 0, intArray.length);
        System.arraycopy(intArray2, 0, array[1], 0, intArray2.length);
        System.arraycopy(intArray3, 0, array[2], 0, intArray3.length);
        return array;
    }
    public List<Integer> convert(List<int[]> list) {

        List<Integer> result  = Arrays.stream(list.stream().findFirst().get()).boxed().collect(Collectors.toList());
        result.addAll(Arrays.stream(list.stream().skip(1).findAny().get()).boxed().collect(Collectors.toList()));
        return result;
    }

}

