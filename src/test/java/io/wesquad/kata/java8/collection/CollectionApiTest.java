package io.wesquad.kata.java8.collection;

import io.wesquad.kata.java8.model.User;
import io.wesquad.kata.util.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CollectionApiTest {

    @Test
    void should_return_names_of_users_using_forEach() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<String> result = new CollectionApi().userNamesByForEach(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0)).isEqualTo("Kong To");
        Assertions.assertThat(result.get(1)).isEqualTo("Peter Ly");
        Assertions.assertThat(result.get(2)).isEqualTo("Mathieu Nguyen");
        Assertions.assertThat(result.get(3)).isEqualTo("Manuel Descartes");
    }

    @Test
    void should_find_user_by_rirstname() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<User> result = new CollectionApi().searchByFirstname(users, "Kong");

        // assert
        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(result.get(0).getLastname()).isEqualTo("To");
    }

    @Test
    void should_replace_elements_using_unary_operator() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<String> result = new CollectionApi().replaceElementsUsingUnaryOperator(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0)).isEqualTo("Full name : To Kong ");
        Assertions.assertThat(result.get(1)).isEqualTo("Full name : Ly Peter ");
        Assertions.assertThat(result.get(2)).isEqualTo("Full name : Nguyen Mathieu ");
        Assertions.assertThat(result.get(3)).isEqualTo("Full name : Descartes Manuel ");
    }

    @Test
    void should_sort_by_nationality() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<User> result = new CollectionApi().sortByNationality(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0).getFirstname()).isEqualTo("Peter");
        Assertions.assertThat(result.get(0).getNationality().toString()).isEqualTo("BELGIAN");
        Assertions.assertThat(result.get(1).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(result.get(1).getNationality().toString()).isEqualTo("CANADIAN");
        Assertions.assertThat(result.get(2).getFirstname()).isEqualTo("Mathieu");
        Assertions.assertThat(result.get(2).getNationality().toString()).isEqualTo("FRENCH");
        Assertions.assertThat(result.get(3).getFirstname()).isEqualTo("Manuel");
        Assertions.assertThat(result.get(3).getNationality().toString()).isEqualTo("FRENCH");
    }

    @Test
    void should_sort_by_nationality_using_stream() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<User> result = new CollectionApi().sortByNationality(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0).getFirstname()).isEqualTo("Peter");
        Assertions.assertThat(result.get(0).getNationality().toString()).isEqualTo("BELGIAN");
        Assertions.assertThat(result.get(1).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(result.get(1).getNationality().toString()).isEqualTo("CANADIAN");
        Assertions.assertThat(result.get(2).getFirstname()).isEqualTo("Mathieu");
        Assertions.assertThat(result.get(2).getNationality().toString()).isEqualTo("FRENCH");
        Assertions.assertThat(result.get(3).getFirstname()).isEqualTo("Manuel");
        Assertions.assertThat(result.get(3).getNationality().toString()).isEqualTo("FRENCH");
    }

    @Test
    void should_sort_by_nationality_using_parallel_stream() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        List<User> result = new CollectionApi().sortByNationality(users);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0).getFirstname()).isEqualTo("Peter");
        Assertions.assertThat(result.get(0).getNationality().toString()).isEqualTo("BELGIAN");
        Assertions.assertThat(result.get(1).getFirstname()).isEqualTo("Kong");
        Assertions.assertThat(result.get(1).getNationality().toString()).isEqualTo("CANADIAN");
        Assertions.assertThat(result.get(2).getFirstname()).isEqualTo("Mathieu");
        Assertions.assertThat(result.get(2).getNationality().toString()).isEqualTo("FRENCH");
        Assertions.assertThat(result.get(3).getFirstname()).isEqualTo("Manuel");
        Assertions.assertThat(result.get(3).getNationality().toString()).isEqualTo("FRENCH");
    }

    @Test
    void should_changeUid_on_first_user() {
        // arrange
        List<User> users = UserFactory.getInstance().few();

        // act
        new CollectionApi().usingIfPresent(users);

        // assert
        Assertions.assertThat(users.get(0).getUid()).isEqualTo(1111);
        Assertions.assertThat(users.get(1).getUid()).isEqualTo(2);
        Assertions.assertThat(users.get(2).getUid()).isEqualTo(3);
        Assertions.assertThat(users.get(3).getUid()).isEqualTo(4);
    }
}