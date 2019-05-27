package io.wesquad.kata.java8.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorLambdaTest {

    @Test
    void should_sum_two_numbers() {
        CalculatorFunctional<Double> anonymous = new CalculatorFunctional<Double>() {
            @Override
            public Double calculate(Double a, Double b) {
                return a + b;
            }
        };

        CalculatorFunctional<Double> functional = (a, b) -> a + b;

        double result = new CalculatorLambda<Double>().calculate(12.0, 3.0, functional);

        Assertions.assertThat(result).isEqualTo(15.0);
    }

    @Test
    void should_sum_two_numbers_using_method_ref() {
        CalculatorFunctional<Double> functional = Double::sum;

        double result = new CalculatorLambda<Double>().calculate(12.0, 3.0, functional);

        Assertions.assertThat(result).isEqualTo(15.0);
    }

    @Test
    void should_substract_two_numbers() {
        CalculatorFunctional<Double> functional = (a, b) -> a - b;

        double result = new CalculatorLambda<Double>().calculate(12.0, 3.0, functional);

        Assertions.assertThat(result).isEqualTo(9.0);
    }

    @Test
    void should_multiply_two_numbers() {
        CalculatorFunctional<Double> functional = (a, b) -> a * b;

        double result = new CalculatorLambda<Double>().calculate(12.0, 3.0, functional);

        Assertions.assertThat(result).isEqualTo(36.0);
    }

    @Test
    void should_divide_two_numbers() {
        CalculatorFunctional<Double> functional = (a, b) -> a / b;

        double result = new CalculatorLambda<Double>().calculate(12.0, 3.0, functional);

        Assertions.assertThat(result).isEqualTo(4.0);
    }
}