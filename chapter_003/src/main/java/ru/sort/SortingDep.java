package ru.sort;

import java.util.Comparator;
import java.util.*;

public class SortingDep implements Comparable<String> {

    @Override
    public int compareTo(String o) {
        return this.compareTo(o);
    }

    public TreeSet<String> findDepartment(String[] in) {

        TreeSet result = new TreeSet<String>();
        for (String st : in) {
            result.add(st);
            List<String> list1 = new ArrayList<String>(Arrays.asList(st.split("/")));
            result.add(list1.get(0));
            result.add(list1.get(0) + "/" + list1.get(1));
        }
        return result;
    }

    public List<String> findDepNames(TreeSet<String> into, int order) {
        List result = new ArrayList<String>();
        for (String st : into) {
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
        TreeSet<String> into = findDepartment(in);
        List<String> departNames = findDepNames(into, order);
        List<TreeSet> result = new ArrayList<>();
        for (String stname : departNames) {
            TreeSet<String> dep = new TreeSet<>();
            dep.add(stname);
            for (String st : into) {
                if (st.contains(stname)) {
                    dep.add(st);
                }
            }
            result.add(dep);
        }

        return result;
    }

}
