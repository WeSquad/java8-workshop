package io.wesquad.kata.java8.interfaces;

public class CalculatorLambda<T> {
    public T calculate(T a, T b, CalculatorFunctional functional) {
        return (T) functional.calculate(a, b);
    }
}
