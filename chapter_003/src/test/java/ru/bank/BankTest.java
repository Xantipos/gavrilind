package ru.bank;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTest {
    @Test
    public void addUsernewUser() {
        Bank bank = new Bank();
        User Dm = new User("Dimon","4905");
        User Dm2 = new User("Dimon","4906");
        bank.addUser(Dm);
        bank.addUser(Dm2);
        bank.addAccountToUser("4905", new Account(1000000,"1234567890"));
        bank.addAccountToUser("4906", new Account(3000000,"1234567891"));
        User result = bank.findUserByPassport("4906");
        Assert.assertThat(result, is(Dm2));
    }
    @Test
    public void findUserByReqTest() {
        Bank bank = new Bank();
        User Dm = new User("Dimon","4905");
        bank.addUser(Dm);
        bank.addAccountToUser("4905", new Account(1000000,"1234567890"));
        User result = bank.findUserByPassport("4905");
        Assert.assertThat(result, is(Dm));
    }

    @Test
    public void transferMoneyTest() {
        Bank bank = new Bank();
        User Dm = new User("Dimon", "4905");
        User Dm2 = new User("Dimon", "4906");
        bank.addUser(Dm);
        bank.addUser(Dm2);
        bank.addAccountToUser("4905", new Account(1000000, "1234567890"));
        bank.addAccountToUser("4906", new Account(3000000, "1234567891"));
        boolean result = bank.transferMoney("4906",  "1234567891", "4905", "1234567890", 2000000);
        Assert.assertThat(result, is(true));
        List<Account> list = bank.getUserAccounts("4905");
        double resultaccount =list.get(0).getValues();
        Assert.assertThat(resultaccount, is(3000000.0));
    }
}