package ru.bank;

import java.util.*;
import java.util.stream.Collectors;


public class Bank {

    public TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();


    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<Account>());
    }

    public void delete(User user) {
        this.treemap.remove(user);
    }


    public void addAccountToUser(String passport, Account account) {
        List<User> list = new ArrayList(treemap.keySet());
        User top = list.stream().filter(user -> user.getPassport().contains(passport)).findFirst().get();
        this.treemap.get(top).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                this.treemap.get(us).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {

        return this.treemap.get(new ArrayList<User>(treemap.keySet()).stream().
                filter(user -> user.getPassport().contains(passport)).findFirst().get());
    }

    public User findUserByPassport(String passport) {
        return new ArrayList<User>(treemap.keySet()).stream().
                filter(user -> user.getPassport().contains(passport)).findFirst().get();
    }

    public User findUserByReq(String requisite) {
        User result = new User();

        Account targetAccount  = treemap.values().stream().flatMap(Collection::stream).
                filter(account -> account.getReqs().contains(requisite)).findFirst().get();

        for (User us : treemap.keySet()) {
            ArrayList<Account> listAccountUser = this.treemap.get(us);
            for (Account accountOfUser : listAccountUser) {
                if (accountOfUser == targetAccount) {
                    result = us;
                }
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

    public Account getAccountByRequisiteFromUserPassport(String passport, String requisite) {

        return getAccounts(findUserByPassport(passport)).stream().
                filter(account -> account.getReqs().contains(requisite)).
                findFirst().get();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account source = getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite);
        Account destination = getAccountByRequisiteFromUserPassport(destPassport, dstRequisite);
        if ((getUserAccounts(srcPassport)).contains(source) & (getUserAccounts(destPassport)).contains(destination)) {
            result = source.transfer(destination, amount);

        }
        return result;
    }

    public String answer() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}