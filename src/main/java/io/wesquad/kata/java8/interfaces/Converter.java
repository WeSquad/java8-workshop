package io.wesquad.kata.java8.interfaces;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
