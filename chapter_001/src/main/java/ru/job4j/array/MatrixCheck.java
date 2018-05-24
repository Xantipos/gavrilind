package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)
* @version $Id$
 * @since 0.1
*/
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int ind = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[0][0] = !data[i][j] && i == j) {result=false;
                    if (result=false) {break;}
                }
            }
        }
        return result;
    }
}



