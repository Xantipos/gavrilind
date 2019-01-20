package ru.jdk19;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student  implements Comparator<Student> {
    private String name;
    private int scope;

    @Override
    public int compare(Student o1, Student o2) {
        int result = o1.name.compareTo(o2.name);
        return result;
    }
    public List<Student> levelOf(List<Student> students, int bound) {
        List<Student> temp1 = students.stream().flatMap(Stream::ofNullable)
                .collect(Collectors.toList());

         List<Student> result = temp1.stream()
                .dropWhile(v -> v.scope > bound)
                .collect(Collectors.toList());
        return result;
    }
}
