package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java7.model.Summary;
import io.wesquad.kata.java8.model.Account;

import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamSummaryStats {

    public Summary statsOnAccountsJava7(List<Account> accounts) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Account account : accounts) {
            int balance = account.getBalance();
            sum += balance;
            min = Math.min(min, balance);
            max = Math.max(max, balance);
        }
        return new Summary(accounts.size(), sum, min, max);
    }

    public IntSummaryStatistics statsOnAccountsJava8(List<Account> accounts) {
        return accounts.stream()
                .mapToInt(Account::getBalance)
                .summaryStatistics();
    }
}
