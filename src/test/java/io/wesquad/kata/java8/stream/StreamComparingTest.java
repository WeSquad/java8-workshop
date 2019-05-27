package io.wesquad.kata.java8.stream;

import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamComparingTest {

    @Test
    void should_return_top_account_java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Account result = new StreamComparing().topAccountJava7(accounts);

        // assert
        Assertions.assertThat(result.getBalance()).isEqualTo(634534);
    }

    @Test
    void should_return_worst_account_java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Account result = new StreamComparing().worstAccountJava7(accounts);

        // assert
        Assertions.assertThat(result.getBalance()).isEqualTo(100);
    }

    @Test
    void should_return_top_account_java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Account result = new StreamComparing().topAccountJava8(accounts);

        // assert
        Assertions.assertThat(result.getBalance()).isEqualTo(634534);
    }

    @Test
    void should_return_worst_account_java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Account result = new StreamComparing().worstAccountJava8(accounts);

        // assert
        Assertions.assertThat(result.getBalance()).isEqualTo(100);
    }
}