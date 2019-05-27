package io.wesquad.kata.java8.optional;

import io.wesquad.kata.java8.model.User;
import io.wesquad.kata.util.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalUsersTest {

    @Test
    void getOptionalAnyUser() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        Optional<User> user = new OptionalUsers().getOptionalAnyUser(users);

        // assert
        Assertions.assertThat(user.get()).isNotNull();
    }

    @Test
    void getAnyUser() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        User user = new OptionalUsers().getAnyUser(users);

        // assert
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getFirstname()).isEqualTo("present");
    }

    @Test
    void getAnyUserWithFallback() {
        // arrange
        List<User> users = new ArrayList<>();

        // act
        User user = new OptionalUsers().getAnyUserWithFallback(users);

        // assert
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getFirstname()).isEqualTo("Kong");
    }

    @Test
    void getAnyUserWithException() {
        // arrange
        List<User> users = new ArrayList<>();

        // act
        assertThrows(IllegalStateException.class,
                () -> new OptionalUsers().getAnyUserWithException(users));

    }
}