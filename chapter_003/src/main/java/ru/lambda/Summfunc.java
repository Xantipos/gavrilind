package ru.lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.*;
import java.util.function.BinaryOperator;
import java.math.*;

public class Summfunc {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        BinaryOperator<Integer> linefunc = (x, y) -> y * x;
        BinaryOperator<Integer> quadraticf = (x, y) -> y * x ^ 2 + y * x;
        BinaryOperator<Double> logfunc = (x, y) -> Math.log(x);
        System.out.println(func.apply(123.1));
        linefunc.apply(start, end);
        return result;
    }

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
}

