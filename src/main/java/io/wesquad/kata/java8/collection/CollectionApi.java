package io.wesquad.kata.java8.collection;

import io.wesquad.kata.java8.model.Operation;
import io.wesquad.kata.java8.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionApi {

    public List<String> userNamesByForEach(List<User> users) {
        List<String> nameList = new ArrayList<>();

        // TODO

        return nameList;
    }

    public List<User> searchByFirstname(List<User> users, String firstname) {

        // TODO

        return users;
    }

    public List<String>  replaceElementsUsingUnaryOperator(List<User> users) {
        List<String> userNames = userNamesByForEach(users);

        // TODO

        return userNames;
    }

    public List<User> sortByNationality(List<User> users) {

        // TODO

        return users;
    }

    public User sortByNationalityUsingStream(List<User> users) {

        Optional<User> user = Optional.empty();

        // TODO

        return user.get();
    }

    public List<User> sortByNationalityUsingParallelStream(List<User> users) {
        Stream<User> nameStream = null;

        // TODO

        return nameStream.collect(Collectors.toList());
    }

    public void usingIfPresent(List<User> users) {

        users.stream().findFirst().ifPresent(new Consumer<User>() {
            @Override
            public void accept(User theUser) {
                doSomethingWithUser(theUser);
            }
        });

        // same as
        users.stream().findFirst().ifPresent(this::doSomethingWithUser);
    }

    private User doSomethingWithUser(User user) {
        user.setUid(1111);
        return user;
    }

}
