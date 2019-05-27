package io.wesquad.kata.util;

import io.wesquad.kata.java8.model.User;

import java.util.Arrays;
import java.util.List;

import static io.wesquad.kata.java8.model.User.Nationality.*;

public class UserFactory {
    private static UserFactory instance = new UserFactory();

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        return instance;
    }

    public User kong() {
        return User.builder().uid(1).firstname("Kong").lastname("To").age(21).nationality(CANADIAN).build();
    }

    public User peter() {
        return User.builder().uid(2).firstname("Peter").lastname("Ly").age(31).nationality(BELGIAN).build();
    }

    public User mathieu() {
        return User.builder().uid(3).firstname("Mathieu").lastname("Nguyen").age(17).nationality(FRENCH).build();
    }

    public User manuel() {
        return User.builder().uid(4).firstname("Manuel").lastname("Descartes").age(34).nationality(FRENCH).build();
    }

    public User Sabrina() {
        return User.builder().uid(5).firstname("Sabrina").lastname("Van Der Valk").age(34).nationality(BELGIAN).build();
    }

    public List<User> few() {
        return Arrays.asList(
                kong(),
                peter(),
                mathieu(),
                manuel()
        );
    }
}
