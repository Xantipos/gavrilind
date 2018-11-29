package ru.lambda;

public class MathUtil {
    public static double line(int left, int second) {
         return left + second;
}

    public static double quadrat(int left, int second) {
        return left * second;
    }

    public static double logor(int left, int second) {
        return Math.log(left) / Math.log(second);
    }
}

