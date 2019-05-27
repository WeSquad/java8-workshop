package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.java8.model.Account.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsGroupingBy {

    public Map<Country, List<Account>> groupByCountryJava7(List<Account> accounts) {
        Map<Country, List<Account>> map = new HashMap<>();
        for (Account account : accounts) {
            if (!map.containsKey(account.getCountry())) {
                map.put(account.getCountry(), new ArrayList<>());
            }
            map.get(account.getCountry()).add(account);
        }
        return map;
    }

    public Map<Country, List<Account>> groupByCountryJava8(List<Account> accounts) {
        return accounts.stream()
                .collect(Collectors.groupingBy(Account::getCountry));
    }

    public Map<Integer, List<Account>> accountsByUserIdJava7(List<Account> accounts) {
        Map<Integer, List<Account>> map = new HashMap<>();
        for (Account account : accounts) {
            if (!map.containsKey(account.getUser().getUid())) {
                map.put(account.getUser().getUid(), new ArrayList<>());
            }
            map.get(account.getUser().getUid()).add(account);
        }
        return map;
    }

    public Map<Integer, List<Account>> accountsByUserIdJava8(List<Account> accounts) {
        return accounts.stream()
                .collect(Collectors.groupingBy(a -> a.getUser().getUid()));
    }
}
