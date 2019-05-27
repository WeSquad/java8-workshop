package io.wesquad.kata.util;

import io.wesquad.kata.java8.model.Account;

import java.util.Arrays;
import java.util.List;

import static io.wesquad.kata.java8.model.Account.Country.*;
import static io.wesquad.kata.java8.model.Account.Type.*;

public class AccountFactory {
    private static AccountFactory instance = new AccountFactory();
    private static UserFactory userFactory = UserFactory.getInstance();

    private AccountFactory() {
    }

    public static AccountFactory getInstance() {
        return instance;
    }

    public List<Account> few() {
        return Arrays.asList(
                Account.builder().uid(1).type(CHECK).country(FRANCE).user(userFactory.kong()).balance(100).build(),
                Account.builder().uid(2).type(CHECK).country(FRANCE).user(userFactory.manuel()).balance(1040).build(),
                Account.builder().uid(3).type(SAVINGS).country(FRANCE).user(userFactory.mathieu()).balance(10340).build(),
                Account.builder().uid(4).type(SAVINGS).country(FRANCE).user(userFactory.kong()).balance(11040).build(),
                Account.builder().uid(5).type(OPERATION).country(FRANCE).user(userFactory.manuel()).balance(13440).build(),

                Account.builder().uid(11).type(CHECK).country(CANADA).user(userFactory.kong()).balance(624).build(),
                Account.builder().uid(12).type(CHECK).country(CANADA).user(userFactory.manuel()).balance(4352).build(),
                Account.builder().uid(13).type(SAVINGS).country(CANADA).user(userFactory.mathieu()).balance(23636).build(),
                Account.builder().uid(14).type(OPERATION).country(CANADA).user(userFactory.kong()).balance(23453).build(),
                Account.builder().uid(15).type(OPERATION).country(CANADA).user(userFactory.manuel()).balance(263466).build(),

                Account.builder().uid(21).type(CHECK).country(BELGIUM).user(userFactory.kong()).balance(130).build(),
                Account.builder().uid(22).type(CHECK).country(BELGIUM).user(userFactory.manuel()).balance(2043).build(),
                Account.builder().uid(23).type(SAVINGS).country(BELGIUM).user(userFactory.mathieu()).balance(5235).build(),
                Account.builder().uid(24).type(OPERATION).country(BELGIUM).user(userFactory.kong()).balance(43634).build(),
                Account.builder().uid(25).type(OPERATION).country(BELGIUM).user(userFactory.manuel()).balance(634534).build()
        );
    }
}
