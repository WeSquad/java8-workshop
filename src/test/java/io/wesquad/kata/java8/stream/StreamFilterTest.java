package io.wesquad.kata.java8.stream;


import io.wesquad.kata.java8.model.Account;
import io.wesquad.kata.util.AccountFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class StreamFilterTest {

    @Test
    public void should_fail_removing_item_from_list_Java7() {
        try {
            // arrange
            List<Account> accounts = AccountFactory.getInstance().few();

            // act
            Set<Account> result = new StreamFilter().accountsOwnedByMinorsJava7(accounts);

            // assert
            org.junit.jupiter.api.Assertions.assertEquals(3, result.size());
        } catch (Exception ex) {
            // let's see what is the issue ?
            ex.printStackTrace();
        }
    }

    @Test
    public void should_keep_accounts_owned_by_minors_Java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class,
                () -> new StreamFilter().accountsOwnedByMinorsJava7(accounts));
    }

    @Test
    public void should_keep_accounts_owned_by_majors_Java7() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Set<Account> result = new StreamFilter().accountsOwnedByMajorsJava7(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(12);
    }

    @Test
    public void should_keep_accounts_owned_by_minors_Java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        Set<Account> result = new StreamFilter().accountsOwnedByMinorsJava8(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void should_keep_accounts_owned_by_majors_Java8() {
        // arrange
        List<Account> accounts = AccountFactory.getInstance().few();

        // act
        List<Account> result = new StreamFilter().accountsOwnedByMajorsJava8(accounts);

        // assert
        Assertions.assertThat(result.size()).isEqualTo(12);
    }

}
