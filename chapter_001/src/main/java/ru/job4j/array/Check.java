package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)

* @version $Id$
 * @since 0.1
*/
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int ind = 0;
        for (int i=0; i<data.length; i++) {
            if(data[0]=!data[i]){ind++;}
        }
        if (ind==0){result=true;}
        return result;
    }
}