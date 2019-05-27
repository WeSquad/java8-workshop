package io.wesquad.kata.java8.optional;

import io.wesquad.kata.java8.model.User;

import java.util.List;
import java.util.Optional;

import static io.wesquad.kata.java8.model.User.Nationality.CANADIAN;

public class OptionalUsers {

    public Optional<User> getOptionalAnyUser(List<User> users) {
        return users.stream().findAny();
    }

    public User getAnyUser(List<User> users) {
        final User.UserBuilder builder = User.builder();
        users.stream().findAny().ifPresent(u -> {
            builder.uid(u.getUid())
            .nationality(u.getNationality())
            .firstname("present")
            .lastname(u.getLastname())
            .age(u.getAge());
        });
        return builder.build();
    }

    public User getAnyUserWithFallback(List<User> users) {
        return users.stream().findAny().orElse(
                User.builder().uid(1).firstname("Kong").lastname("To").age(21).nationality(CANADIAN).build()
        );
    }

    public User getAnyUserWithException(List<User> users) {
        return users.stream().findAny().orElseThrow(() -> new IllegalStateException("not ok"));
    }

}
