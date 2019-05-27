package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.User;
import io.wesquad.kata.util.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class CollectorsToMapTest {

    @Test
    void should_return_map_of_users_by_id_java7() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        Map<Integer, User> result = new CollectorsToMap().usersByIdJava7(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
    }

    @Test
    void should_return_map_of_users_by_id_java8() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        Map<Integer, User> result = new CollectorsToMap().usersByIdJava8(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
    }

}