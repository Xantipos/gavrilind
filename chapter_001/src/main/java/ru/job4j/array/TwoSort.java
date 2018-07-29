package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class TwoSort {

    public static int[] sort(int[] array1, int[] array2) {
        int len1 = array1.length, len2 = array2.length;
        int a = 0, b = 0;
        int len = len1 + len2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (array1[a] > array2[b]) {
                    result[i] = array2[b++];
                } else {
                    result[i] = array1[a++];
                }
            } else  if (b < len2) {
                result[i] = array2[b++];
            } else {
                result[i] = array1[a++];
            }
        }
        return result;
    }
}