package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToMap {

    public Map<Integer, User> usersByIdJava7(List<User> users) {
        Map<Integer, User> map = new HashMap<>();
        for (User user : users) {
                map.put(user.getUid(), user);
        }
        return map;
    }

    public Map<Integer, User> usersByIdJava8(List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getUid, u -> u));
    }

}
