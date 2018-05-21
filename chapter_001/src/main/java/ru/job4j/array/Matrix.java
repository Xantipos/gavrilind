package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class Matrix {
    int[][] multiple(int size){
        int[][] data = new int[size][size];
        for (int i=1; i<size; i++){
            for (int j=1; j<size; j++){
                data[i][j]=(i)*(j);
            }
        }
        for (int i=0; i<size; i++){data[i][0]=i;}
        for (int j=0; j<size; j++){data[0][j]=j;}
        return data;
    }
}