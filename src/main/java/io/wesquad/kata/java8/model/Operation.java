package io.wesquad.kata.java8.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    public enum Type {
        DEPOSIT,
        WITHDRAWAL,
        PURCHASE,
        TRANSFER;
    }

    private Type type;
    private Instant date;
    private BigDecimal amount;
    private String description;
}
