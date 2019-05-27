package io.wesquad.kata.java8.stream;


import io.wesquad.kata.java8.model.Account;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFilter {

    private static final int MAJOR_MIN_AGE = 18;

    // should not do this
    public Set<Account> accountsOwnedByMinorsJava7(List<Account> accounts) {
        for (Account account : accounts) {
            if (account.getUser().getAge() >= MAJOR_MIN_AGE) {
                accounts.remove(account);
            }
        }
        return new HashSet<>(accounts);
    }

    public Set<Account> accountsOwnedByMajorsJava7(List<Account> accounts) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getUser().getAge() >= MAJOR_MIN_AGE) {
                result.add(account);
            }
        }
        return new HashSet<>(result);
    }

    public Set<Account> accountsOwnedByMinorsJava8(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.getUser().getAge() < MAJOR_MIN_AGE)
                .collect(Collectors.toSet());
    }

    public List<Account> accountsOwnedByMajorsJava8(List<Account> accounts) {
        return accounts.parallelStream()
                .filter(a -> a.getUser().getAge() >= MAJOR_MIN_AGE)
                .sorted(Comparator.comparing(Account::getBalance))
                .collect(Collectors.toList());
    }

}
