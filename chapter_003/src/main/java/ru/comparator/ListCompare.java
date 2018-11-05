package ru.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int koeff = Integer.compare(left.length(), right.length());
        int i = 0;
        while (i < left.length() & i < right.length()) {
            char chleft = left.charAt(i);
            char chright = right.charAt(i);
            int chcom = Character.compare(chleft, chright);
            result = result + chcom;
            i++;
        }
        return result + koeff;
    }
}
