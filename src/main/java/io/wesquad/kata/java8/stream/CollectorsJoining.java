package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoining {

    public String namesAsStringFromListJava7(List<User> users) {
        String prefix = "Names: ";
        StringBuilder sb = new StringBuilder(prefix);
        for (User user : users) {
            if (sb.length() > prefix.length()) {
                sb.append(", ");
            }
            sb.append(user.getFirstname()).append(" ").append(user.getLastname());
        }
        return sb.toString();
    }

    public String namesAsStringFromListJava8(List<User> users) {

        // TODO : requires map

        return "";
    }
}
