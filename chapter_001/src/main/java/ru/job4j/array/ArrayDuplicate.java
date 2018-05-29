package ru.job4j.array;

import java.util.Arrays;
/*

* @author Dm Gavrilin (anubite@bk.ru)


* @version $Id$
 
* @since 0.1

*/
public class ArrayDuplicate {
    String[] array;
    public String[] remove(String[] array) {
        int size = array.length - 1;
        int con = 0;
        for (int numb = 0; numb < array.length - 1; numb++) {
            for (int index = 0; index < size; index++) {
                String akkum;
                if (array[numb] == array[index]) {
                    akkum = array[index];
                    array[index] = array[size];
                    array[size] = akkum;
                    size = size - 1;
                    con++;
                }
            }
        }
        String[] copingarray = Arrays.copyOf(array, con - 1);
        return copingarray;
    }
}







 
