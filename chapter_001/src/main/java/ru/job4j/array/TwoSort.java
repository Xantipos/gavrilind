package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class TwoSort {

    public static int[] sort(int[] array1, int[] array2) {

        int[] result = new int[array1.length + array2.length];
        int len3 = array1.length+array2.length-1;
        int len1=array1.length - 1;
        int len2=array2.length - 1;

        if(len1 > len2){
            int dev = len1 - len2;
            while(dev > 0) {
                result[len3] = array1[len1];
                dev--;
                len3--;
                len1--;
            }

            int index3 = 0;
            for (int index = 0; index < (array2.length); index++) {
                if (array1[index] > array2[index]) {
                    result[index3] = array2[index];
                    index3++;
                    result[index3] = array1[index];
                    index3++;
                }
            }
        }
        else if(len2>len1){
            int dev2 = len2 - len1;
            while(dev2 > 0) {
                result[len3] = array2[len2];
                dev2--;
                len3--;
                len2--;
            }

            int index3 = 0;
            for (int index = 0; index < (array1.length); index++) {
                if (array1[index] > array2[index]) {
                    result[index3] = array2[index];
                    index3++;
                    result[index3] = array1[index];
                    index3++;
                }
            }
        }

       else if(len1 == len2){
            int index3 = 0;
            for (int index = 0; index < (array1.length); index++) {
                if (array1[index] > array2[index]) {
                    result[index3] = array2[index];
                    index3++;
                    result[index3] = array1[index];
                    index3++;
                }
            }
        }
        return result;
    }
}
