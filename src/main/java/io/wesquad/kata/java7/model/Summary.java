package io.wesquad.kata.java7.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    private long count;
    private long sum;
    private int min;
    private int max;
}
