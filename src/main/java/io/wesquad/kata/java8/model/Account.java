package io.wesquad.kata.java8.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    public enum Type {
        CHECK,
        SAVINGS,
        OPERATION
    }

    public enum Country {
        CANADA,
        FRANCE,
        BELGIUM
    }

    private Type type;
    private int uid;
    private User user;
    private Country country;
    private int balance;
    private List<Operation> operations;
}
