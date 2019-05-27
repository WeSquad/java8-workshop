package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java7.model.Summary;
import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamSummaryStatsTest {

    @Test
    void should_create_summary_of_account_balances_Java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Summary result = new StreamSummaryStats().statsOnAccountsJava7(accounts);

        // assert
        Assertions.assertThat(result.getCount()).isEqualTo(15);
        Assertions.assertThat(result.getSum()).isEqualTo(1037067L);
        Assertions.assertThat(result.getMin()).isEqualTo(100L);
        Assertions.assertThat(result.getMax()).isEqualTo(634534L);
    }

    @Test
    void should_create_summary_of_account_balances_Java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        IntSummaryStatistics result = new StreamSummaryStats().statsOnAccountsJava8(accounts);

        // assert
        Assertions.assertThat(result.getCount()).isEqualTo(15);
        Assertions.assertThat(result.getSum()).isEqualTo(1037067L);
        Assertions.assertThat(result.getMin()).isEqualTo(100L);
        Assertions.assertThat(result.getMax()).isEqualTo(634534L);
    }
}