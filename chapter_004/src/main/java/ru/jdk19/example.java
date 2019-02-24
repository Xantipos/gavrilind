package ru.jdk19;

import java.util.List;
import java.util.stream.Stream;

public class example {



    public static void main(String[] args) {
        List.of(2, 4, 3, 4).stream()
                .takeWhile(v -> v % 2 == 0)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);

        List.of(2, 4, 3, 4).stream()
                .dropWhile(v -> v % 2 == 0)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);

        Stream.of(1, null, 2, null, 3)
                .flatMap(Stream::ofNullable)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
    }
}
