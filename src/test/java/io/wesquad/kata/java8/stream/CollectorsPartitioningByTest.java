package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CollectorsPartitioningByTest {

    @Test
    void should_partitionby_min_limit_java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Boolean, List<Account>> result = new CollectorsPartitioningBy().partitionMinLimitJava7(accounts, 10000);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(true).size()).isEqualTo(8);
        Assertions.assertThat(result.get(false).size()).isEqualTo(7);
    }

    @Test
    void should_partitionby_min_limit_java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Map<Boolean, List<Account>> result = new CollectorsPartitioningBy().partitionMinLimitJava8(accounts, 10000);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(true).size()).isEqualTo(8);
        Assertions.assertThat(result.get(false).size()).isEqualTo(7);
    }
}