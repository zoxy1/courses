package ru.job4j.collections.bank;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BankTest {
    @Test
    public void addUser() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");

        bank.addUser(user);

        assertTrue(bank.getUsers().containsKey(user));
    }

    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");

        bank.addUser(user);
        bank.deleteUser(user);

        assertFalse(bank.getUsers().containsKey(user));
    }

    @Test
    public void addAccountToUserIsAccount() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");
        Account account = new Account(100, "requisites1");

        bank.addUser(user);
        bank.addAccountToUser("passport1", account);

        assertThat(bank.getUsers().get(user).get(0), is(new Account(100, "requisites1")));
    }

    @Test
    public void deleteAccountFromUserIsNotAccount() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");
        Account account = new Account(100, "requisites1");

        bank.addUser(user);
        bank.addAccountToUser("passport1", account);
        bank.deleteAccountFromUser("passport1", account);

        assertTrue(bank.getUsers().get(user).size() == 0);
    }

    @Test
    public void getUserAccountsIsUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");

        bank.addUser(user);
        bank.addAccountToUser("passport1", new Account(100, "requisites1"));
        bank.addAccountToUser("passport1", new Account(10, "requisites2"));

        assertThat(bank.getUserAccounts("passport1"), is(Arrays.asList(
                new Account(100, "requisites1"), new Account(10, "requisites2"))));
    }

    @Test
    public void transferMoneyFromOneUserToOther() {
        Bank bank = new Bank();
        User user1 = new User("Anton", "passport1");
        User user2 = new User("Andrey", "passport2");

        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("passport1", new Account(100, "requisites1"));
        bank.addAccountToUser("passport2", new Account(10, "requisites2"));
        bank.transferMoney("passport1", "requisites1", "passport2",
                "requisites2", 40);

        assertThat(bank.getUsers().get(user1).get(0).getValue(), is(60L));
        assertThat(bank.getUsers().get(user2).get(0).getValue(), is(50L));
    }

    @Test
    public void transferMoneyFromOneAccountToOtherOneUser() {
        Bank bank = new Bank();
        User user = new User("Anton", "passport1");

        bank.addUser(user);
        bank.addAccountToUser("passport1", new Account(100, "requisites1"));
        bank.addAccountToUser("passport1", new Account(10, "requisites2"));
        bank.transferMoney("passport1", "requisites1", "passport1",
                "requisites2", 40);

        assertThat(bank.getUsers().get(user).get(0).getValue(), is(60L));
        assertThat(bank.getUsers().get(user).get(1).getValue(), is(50L));
    }
}
