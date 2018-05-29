package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class BubbleSort {
    public int[] sort(int[] array) {
        for (int index2 = 0; index2 < (array.length) - 1; index2++) {
            for (int index = 0; index < (array.length) - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int akkum = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = akkum;
                }
            }
        }
        return array;
    }
}