package io.wesquad.kata.java8.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void convert() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
        Assertions.assertThat(converted).isEqualTo(123);
    }
}