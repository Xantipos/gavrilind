/**
 * Простейший калькулятор
 * сложение, вычитание, деление и умножение двух чисел 
 * @author Dmitriy Gavrilin (anubite@bk.ru)
 * @version $Id$
 * @since 0.1
 */
package ru.job4j.calculator;
public class Calculator {
    //добавим внутреннее поле видимо для вывода результата
    private double result;

    public double add(double first, double second) {
        this.result = first + second;
        return this.result;
    }
    public double subtract(double first, double second) {
        this.result = first - second;
        return this.result;
    }
    public double div(double first, double second) {
        this.result = first / second;
        return this.result;
    }
    public double multiple(double first, double second) {
        this.result = first * second;
        return this.result;
    }
    public double getResult() {

        return this.result;
    }
}