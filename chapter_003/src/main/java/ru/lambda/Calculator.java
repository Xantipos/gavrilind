package ru.lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.*;
import java.util.function.BinaryOperator;
public class Calculator {

    public interface Operation {
        double calc(int left, int right);
    }
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                MathUtil::line,
                result -> System.out.println("Линейная функция значение" + result)
        );

        calc.multiple(
                0, 10, 2,
                MathUtil::logor,
                result -> System.out.println("Логарифмическая функция значеие" +result)
        );

        calc.multiple(
                0, 10, 2,
                MathUtil::quadrat,
                result -> System.out.println("Квадратичная функция значенеи" +result)
        );
    }
}
