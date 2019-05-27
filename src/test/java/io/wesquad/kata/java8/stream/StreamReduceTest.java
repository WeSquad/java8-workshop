package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamReduceTest {

    @Test
    void should_sum_all_account_balances_Java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        long result = new StreamReduce().sumOfAllAccontBalancesJava7(accounts);

        // assert
        Assertions.assertThat(result).isEqualTo(1037067L);
    }

    @Test
    void should_sum_all_account_balances_Java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        long result = new StreamReduce().sumOfAllAccontBalancesJava8(accounts);

        // assert
        Assertions.assertThat(result).isEqualTo(1037067L);
    }
}