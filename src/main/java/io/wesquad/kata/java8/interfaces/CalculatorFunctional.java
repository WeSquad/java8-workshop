package io.wesquad.kata.java8.interfaces;

@FunctionalInterface
public interface CalculatorFunctional<T> {
    T calculate(T a, T b);
}
