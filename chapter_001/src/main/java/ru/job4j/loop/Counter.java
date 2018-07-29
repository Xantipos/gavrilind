package ru.job4j.loop;
/* ������� ����� ������ ����� � ���������
 * @author Dm Gavrilin (anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Counter {
//int start;
//int finish;

public int add(int start, int finish) {
    int result = 0;
    for (int i = start; i <= finish; i++) {
        if (i % 2 == 0) {
            result = result + i;
            System.out.println(result);
        }
        //System.out.println(result);
    }
    return result;
}
}