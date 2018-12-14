package ru.search;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(List<Task> in) {
        List<Task> res  = in.stream().sorted(Comparator.comparing(Task::getPriority).reversed()).collect(Collectors.toList());
        tasks.addAll(res);
        //for(Task ts : tasks){System.out.println(ts.getDesc());}
    }

    public Task take() {
        return this.tasks.poll();
    }
    public void print() {
        for(Task ts : tasks){System.out.println("Печатаем элементы очереди " + ts.getDesc());}
    }
}