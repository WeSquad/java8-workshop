package io.wesquad.kata.java8.collection;

import io.wesquad.kata.java8.model.User;
import io.wesquad.kata.util.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MapApiTest {


    @Test
    void should_return_default_user_when_not_existed() {
        // arrange
        Map<Integer, User> usersById = UserFactory.getInstance().few().stream()
                .collect(Collectors.toMap(User::getUid, u -> u));

        // act
        User result = new MapApi().getDefaultValue(usersById, 6);

        // assert
        Assertions.assertThat(result.getFirstname()).isEqualTo("Kong");
    }

    @Test
    void should_put_user_when_not_existed() {
        // arrange
        Map<Integer, User> usersById = UserFactory.getInstance().few().stream()
                .collect(Collectors.toMap(User::getUid, u -> u));
        Assertions.assertThat(usersById.get(6)).isNull();

        // act
        new MapApi().putIfNotExisting(usersById, 6);

        // assert
        Assertions.assertThat(usersById.get(6).getFirstname()).isEqualTo("Kong");
    }

    @Test
    void mergeValuesOfExistingUserWithNewData() {
        // arrange
        Map<Integer, User> usersById = UserFactory.getInstance().few().stream()
                .collect(Collectors.toMap(User::getUid, u -> u));
        Assertions.assertThat(usersById.get(6)).isNull();

        // act
        new MapApi().mergeValuesOfExistingUserWithNewData(usersById, 4, UserFactory.getInstance().kong());

        // assert
        Assertions.assertThat(usersById.get(4).getFirstname()).isEqualTo("Kong");
    }

    @Test
    void ignoringAbsentKeys() {
        // arrange
        Map<Integer, User> usersById = UserFactory.getInstance().few().stream()
                .collect(Collectors.toMap(User::getUid, u -> u));
        Assertions.assertThat(usersById.get(6)).isNull();

        // act
        new MapApi().ignoringAbsentKeys(usersById);

        // assert
        Assertions.assertThat(usersById.get(1).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(usersById.get(2).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(usersById.get(3).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(usersById.get(4).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(usersById.get(5)).isNull();
        Assertions.assertThat(usersById.get(6)).isNull();
    }
}