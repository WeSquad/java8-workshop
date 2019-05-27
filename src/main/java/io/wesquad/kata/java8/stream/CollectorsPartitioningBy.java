package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPartitioningBy {

    public Map<Boolean, List<Account>> partitionMinLimitJava7(List<Account> accounts, long minLimit) {
        Map<Boolean, List<Account>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Account account : accounts) {
            map.get(account.getBalance() >= minLimit).add(account);
        }
        return map;
    }

    public Map<Boolean, List<Account>> partitionMinLimitJava8(List<Account> accounts, long minLimit) {
        return accounts.stream()
            .collect(Collectors.partitioningBy(a -> a.getBalance() >= minLimit));
    }
}
