package ru.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void delete(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                this.treemap.get(us).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                this.treemap.get(us).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                result = this.treemap.get(us);
            }
        }
        return result;
    }

    public User getUser(String passport) {
        User result = new User();
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                result = us;
            }
        }
        return result;
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account destination = new Account(0, "newreq");
        Account source = new Account(0, "newreq");

        for (Account acc : getUserAccounts(destPassport)) {
            if  (acc.getReqs() == dstRequisite) {
                destination = acc;
            }
        }

        for (Account acc : getUserAccounts(srcPassport)) {
            if  (acc.getReqs() == srcRequisite) {
                source = acc;
            }
        }
        boolean result = source.transfer(destination, amount);
        return result;
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}