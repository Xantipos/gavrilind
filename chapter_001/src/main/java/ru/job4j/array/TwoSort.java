package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class TwoSort {

    public static int[] sort(int[] array1, int[] array2) {

        int[] result = new int[array1.length*2];
        int index3 = 0;
        for (int index = 0; index < (array1.length); index++) {

            if(array1[index]>array2[index]){

                result[index3] = array2[index];
                index3++;
                result[index3] = array1[index];
                index3++;
            }

        }
        return result;
    }
}
