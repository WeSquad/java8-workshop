package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.java8.model.Account.Country;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class CollectorsGroupingByTest {

    @Test
    public void should_group_by_country_with_java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Country, List<Account>> result = new CollectorsGroupingBy().groupByCountryJava7(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void should_group_by_country_with_java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Country, List<Account>> result = new CollectorsGroupingBy().groupByCountryJava8(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(3);
    }


    @Test
    void should_return_map_of_accounts_by_userId_java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Integer, List<Account>> result = new CollectorsGroupingBy().accountsByUserIdJava7(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void should_return_map_of_accounts_by_userId_java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Integer, List<Account>>  result = new CollectorsGroupingBy().accountsByUserIdJava8(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}