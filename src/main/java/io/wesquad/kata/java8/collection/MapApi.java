package io.wesquad.kata.java8.collection;

import io.wesquad.kata.java8.model.User;

import java.util.Map;
import java.util.function.BiFunction;

import static io.wesquad.kata.java8.model.User.Nationality.CANADIAN;

public class MapApi {

    private User kong() {
        return User.builder().uid(1).firstname("Kong").lastname("To").age(21).nationality(CANADIAN).build();
    }

    public User getDefaultValue(Map<Integer, User> usersById, int id) {
        return usersById.getOrDefault(id, kong());
    }

    public User putIfNotExisting(Map<Integer, User> usersById, int id) {
        return usersById.putIfAbsent(id, kong());
    }

    public void mergeValuesOfExistingUserWithNewData(Map<Integer, User> usersById, int id, User userWithNewData) {
        BiFunction<User, User, User> remappingFunction = (oldVal, newVal) -> {
            oldVal.setFirstname(newVal.getFirstname());
            return oldVal;
        };
        usersById.merge(id, userWithNewData, remappingFunction);
    }

    public void ignoringAbsentKeys(Map<Integer, User> usersById) {
        BiFunction<Integer, User, User> remappingFunction = (key, val) -> {
            val.setFirstname("Kong");
            return val;
        };
        usersById.computeIfPresent(1, remappingFunction);
        usersById.computeIfPresent(2, remappingFunction);
        usersById.computeIfPresent(3, remappingFunction);
        usersById.computeIfPresent(4, remappingFunction);
        usersById.computeIfPresent(5, remappingFunction);
        usersById.computeIfPresent(6, remappingFunction);
    }

}
