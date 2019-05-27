package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StreamFlatMapTest {

    @Test
    public void should_convert_to_list_from_list_of_list_with_java7() {
        // arrange
        List<String> list = Lists.list("12", "123", "1234", "12345", "123456");
        List<List<String>> listOfList = Lists.list(list);

        // act
        List<String> result = new StreamFlatMap().flatMapListOfListToListJava7(listOfList);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void should_convert_to_list_from_list_of_list_with_java8() {
        // arrange
        List<String> list = Lists.list("12", "123", "1234", "12345", "123456");
        List<List<String>> listOfList = Lists.list(list);

        // act
        List<String> result = new StreamFlatMap().flatMapListOfListToListJava8(listOfList);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(5);
    }

    @Test
    public void should_return_accounts_from_map_of_accounts_by_userId_Java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();
        Map<Integer, List<Account>> accountsByUserId =  new CollectorsGroupingBy().accountsByUserIdJava7(accounts);

        // act
        List<Account> result = new StreamFlatMap().accountsByUserIdToListJava7(accountsByUserId);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(15);
    }

    @Test
    public void should_return_accounts_from_map_of_accounts_by_userId_Java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();
        Map<Integer, List<Account>> accountsByUserId =  new CollectorsGroupingBy().accountsByUserIdJava8(accounts);

        // act
        List<Account> result = new StreamFlatMap().accountsByUserIdToListJava8(accountsByUserId);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(15);
    }
}
