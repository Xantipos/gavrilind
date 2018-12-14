package ru.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import  java.util.ArrayList;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", spent=" + spent +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<Task>();
        Task task1 = new Task("Bug #1", 100);
        Task task2 = new Task("Task #2", 100);
        Task task3 = new Task("Bug #3", 100);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<String> names = tasks.stream().map(
                task -> task.name
        ).collect(Collectors.toList());
        names.forEach(System.out::println);

        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);

        System.out.println("Сумма тотал " + total);
    }
}
