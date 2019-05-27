package io.wesquad.kata.java8.collection;

import io.wesquad.kata.java8.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionApi {

    public List<String> userNamesByForEach(List<User> users) {
        List<String> nameList = new ArrayList<>();

        Consumer<User> consumer = user -> nameList.add(user.getLastname() + " " + user.getFirstname());
        users.forEach(consumer);

        return nameList;
    }

    public List<User> searchByFirstname(List<User> users, String firstname) {
        Predicate<User> predicate = user -> user.getFirstname().contains(firstname);
        users.removeIf(predicate);
        return users;
    }

    public List<String>  replaceElementsUsingUnaryOperator(List<User> users) {
        List<String> userNames = userNamesByForEach(users);
        UnaryOperator<String> unaryOperator = e -> "Full name : " + e + " ";
        userNames.replaceAll(unaryOperator);
        return userNames;
    }

    public List<User> sortByNationality(List<User> users) {
        Comparator<User> comparator = Comparator.comparing(User::getNationality);
        users.sort(comparator);
        return users;
    }

    public User sortByNationalityUsingStream(List<User> users) {
        Comparator<User> comparator = Comparator.comparing(User::getNationality);
        Stream<User> nameStream =  users.stream().sorted(comparator);
        return nameStream.findFirst().get();
    }

    public List<User> sortByNationalityUsingParallelStream(List<User> users) {
        Comparator<User> comparator = Comparator.comparing(User::getNationality);
        Stream<User> nameStream =  users.parallelStream().sorted(comparator);
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
