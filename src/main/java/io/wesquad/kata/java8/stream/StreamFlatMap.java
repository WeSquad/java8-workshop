package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class StreamFlatMap {
    public List<String> flatMapListOfListToListJava7(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        for (List<String> subList : list) {
            for (String value : subList) {
                result.add(value);
            }
        }
        return result;
    }

    public List<String> flatMapListOfListToListJava8(List<List<String>> list) {
        return list.stream()
                .flatMap(List::stream)
                .collect(toList());
    }

    public List<Account> accountsByUserIdToListJava7(Map<Integer, List<Account>> accountsByUserId) {
        List<Account> result = new ArrayList<>();
        for (List<Account> subList : accountsByUserId.values()) {
            for (Account value : subList) {
                result.add(value);
            }
        }
        return result;
    }

    public List<Account> accountsByUserIdToListJava8(Map<Integer, List<Account>> accountsByUserId) {
        return accountsByUserId.values()
                .stream()
                .flatMap(List::stream)
                .collect(toList());
    }
}
