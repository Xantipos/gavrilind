package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class Turn {
    public static int[] back(int[] array) {
        if (array.length % 2 != 0) {
            int len = (array.length) - 1;
            int stop = len;
            for (int index = 0; index == stop; index++) {
                int current = array[len];
                array[len] = array[index];
                array[index] = current;
                len = len - 1;
                return array;
            }
        }
        int len = (array.length) - 1;
        int half = (array.length) / 2;
        int centr = half;
        for (int index = 0; index < half; index++) {
            int current = array[len];
            array[len] = array[index];
            array[index] = current;
            len = len - 1;
        }
        len = (array.length) - 1;
        for (int index = half + 1; index < array.length; index++) {
            int current = array[len];
            array[len] = array[index];
            array[index] = current;
            len = len - 1;
        }
        return array;
    }
}
