package io.wesquad.kata.java8.interfaces;

public interface CalculatorDefaultMethod {

    double calculate(int a, int b);

    default double add(double a, double b) {
        return a + b;
    }

    default double substract(double a, double b) {
        return a - b;
    }

    default double multiply(double a, double b) {
        return a * b;
    }

    default double divide(double a, double b) {
        return a / b;
    }
}
