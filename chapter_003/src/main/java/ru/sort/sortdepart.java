package ru.sort;

import java.util.Comparator;
import java.util.*;

public class Sortdepart implements Comparable<String> {
    @Override
    public int compareTo(String o) {
        return this.compareTo(o);
    }


        public List<String> findDepartment(String[] in, int order) {
            List result = new ArrayList<String>();
            for (String st : in) {
                if (!st.contains("/")) {
                    result.add(st);
                }
            }
            Collections.sort(result);
            if (order == 1) {
                Collections.reverse(result);
            }

            return result;
        }

        public List<TreeSet> addToDepart(String[] in, int order) {
        List<String> departnames = findDepartment(in, order);
        List<TreeSet> result = new ArrayList<>();
        for (String stname : departnames) {
            TreeSet<String> dep = new TreeSet<>();
            dep.add(stname);
            for (String st : in) {
                if (st.contains(stname)) {
                    dep.add(st);
                }
            }
            result.add(dep);
        }

        return result;
    }

}
