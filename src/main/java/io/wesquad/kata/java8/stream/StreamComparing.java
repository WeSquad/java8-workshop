package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;

import java.util.Comparator;
import java.util.List;

public class StreamComparing {

    public Account topAccountJava7(List<Account> accounts) {
        Account topAccount = null;
        for (Account account : accounts) {
            if (topAccount == null || account.getBalance() > topAccount.getBalance()) {
                topAccount = account;
            }
        }
        return topAccount;
    }

    public Account worstAccountJava7(List<Account> accounts) {
        Account worstAccount = null;
        for (Account account : accounts) {
            if (worstAccount == null || account.getBalance() < worstAccount.getBalance()) {
                worstAccount = account;
            }
        }
        return worstAccount;
    }

    public Account topAccountJava8(List<Account> accounts) {

        // TODO

        return new Account();
    }

    public Account worstAccountJava8(List<Account> accounts) {

        // TODO

        return new Account();
    }

}
