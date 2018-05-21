package ru.job4j.array;
/*
* @author Dm Gavrilin (anubite@bk.ru)
* @version $Id$
 * @since 0.1
*/
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray(); }
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index <= value.length - 1; index++) {
            if (value[index] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}