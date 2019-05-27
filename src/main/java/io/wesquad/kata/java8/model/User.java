package io.wesquad.kata.java8.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int uid;
    private String lastname;
    private String firstname;
    private int age;
    private Nationality nationality;

    public enum Nationality {
        CANADIAN,
        FRENCH,
        BELGIAN
    }
}
