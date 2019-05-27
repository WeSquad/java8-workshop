package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;

import java.util.List;

public class StreamReduce {

    public long sumOfAllAccontBalancesJava7(List<Account> accounts) {
        long total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public long sumOfAllAccontBalancesJava8(List<Account> accounts) {
        return accounts.stream()
                .mapToLong(Account::getBalance)
                .reduce(0, Long::sum);
    }
}
