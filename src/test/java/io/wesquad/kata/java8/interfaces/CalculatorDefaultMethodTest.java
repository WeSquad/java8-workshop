package io.wesquad.kata.java8.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorDefaultMethodTest {

    @Test
    void add() {
        CalculatorDefaultMethod calculator = new CalculatorDefaultMethod() {
            @Override
            public double calculate(int a, int b) {
                return add(a, b);
            }
        };

        double result = calculator.calculate(12, 15);

        Assertions.assertThat(result).isEqualTo(27);
    }

    @Test
    void substract() {
        CalculatorDefaultMethod calculator = new CalculatorDefaultMethod() {
            @Override
            public double calculate(int a, int b) {
                return substract(a, b);
            }
        };

        double result = calculator.calculate(12, 1);

        Assertions.assertThat(result).isEqualTo(11);
    }

    @Test
    void multiply() {
        CalculatorDefaultMethod calculator = new CalculatorDefaultMethod() {
            @Override
            public double calculate(int a, int b) {
                return multiply(a, b);
            }
        };

        double result = calculator.calculate(12, 3);

        Assertions.assertThat(result).isEqualTo(36);
    }

    @Test
    void divide() {
        CalculatorDefaultMethod calculator = new CalculatorDefaultMethod() {
            @Override
            public double calculate(int a, int b) {
                return divide(a, b);
            }
        };

        double result = calculator.calculate(12, 3);

        Assertions.assertThat(result).isEqualTo(4);
    }
}