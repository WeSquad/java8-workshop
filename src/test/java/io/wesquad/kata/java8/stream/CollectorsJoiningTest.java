package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.User;
import io.wesquad.kata.util.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CollectorsJoiningTest {

    @Test
    public void should_join_string_from_list_with_java7() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        String result = new CollectorsJoining().namesAsStringFromListJava7(users);

        // assert
        String[] names = result.split(", ");
        Assertions.assertThat(names.length).isEqualTo(4);
        Assertions.assertThat(names[0].substring("Names: ".length())).isEqualTo("Kong To");
        Assertions.assertThat(names[1]).isEqualTo("Peter Ly");
        Assertions.assertThat(names[2]).isEqualTo("Mathieu Nguyen");
        Assertions.assertThat(names[3]).isEqualTo("Manuel Descartes");
    }

    @Test
    public void should_join_string_from_list_with_java8() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        String result = new CollectorsJoining().namesAsStringFromListJava8(users);

        // assert
        String[] names = result.substring("Names: ".length()).split(", ");
        Assertions.assertThat(names.length).isEqualTo(4);
        Assertions.assertThat(names[0]).isEqualTo("Kong To");
        Assertions.assertThat(names[1]).isEqualTo("Peter Ly");
        Assertions.assertThat(names[2]).isEqualTo("Mathieu Nguyen");
        Assertions.assertThat(names[3]).isEqualTo("Manuel Descartes");
    }
}