package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == data[i + 1]) {
                result = true;
               }
            }
        return result;
    }
}