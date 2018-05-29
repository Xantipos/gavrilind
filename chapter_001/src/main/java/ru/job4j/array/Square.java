package ru.job4j.array;
/**
 * @author Dm Gavrilin (anubite@bk.ru)

 * @version $Id$
 * @since 0.1
 */
public class Square {
    public static int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index != bound; index++) {
            rst[index] = index * index;
            rst[0] = 1;
            System.out.println(rst[index]);
        }
        return rst;
    }
}