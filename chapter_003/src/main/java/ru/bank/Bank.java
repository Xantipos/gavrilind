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
        Optional<User> top = list.stream().filter(user -> user.getPassport().contains(passport)).findFirst();
        if (top.isPresent()) {
        this.treemap.get(top.get()).add(account);
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
        List<Account> result = null;
        Optional<User> acc = treemap.keySet().stream().
                filter(user -> user.getPassport().contains(passport)).findFirst();
        if (acc.isPresent()) result = this.treemap.get(acc.get());
        return result;
    }

    public Optional <User> findUserByPassport(String passport) {
        Optional<User> result = Optional.empty();
            Optional<User> arr = (treemap.keySet()).stream().
                filter(user -> user.getPassport().contains(passport)).findFirst();
            if (arr.isPresent()){
                result = arr;
            }
            return result;
    }

    public User findUserByReq(String requisite) {
        User result = new User();
        Optional<Account> targetAccount = Optional.empty();
        Optional<Account> targetTemp  = treemap.values().stream().flatMap(Collection::stream).
                filter(account -> account.getReqs().contains(requisite)).findFirst();
        if (targetTemp.isPresent()) targetAccount = targetTemp;
        for (User us : treemap.keySet()) {
            ArrayList<Account> listAccountUser = this.treemap.get(us);
            for (Account accountOfUser : listAccountUser) {
                if (accountOfUser == targetAccount.get()) {
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

    public Optional<Account> getAccountByRequisiteFromUserPassport(String passport, String requisite) {
        Optional<User> user = findUserByPassport(passport);
        Optional<Account> acc = Optional.empty();
        if (user.isPresent()){
        acc = getAccounts(findUserByPassport(passport).get()).stream().
                filter(account -> account.getReqs().contains(requisite)).
                findFirst();
        }
        return acc;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Optional<Account> source = getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite);
        Optional<Account> dest = getAccountByRequisiteFromUserPassport(destPassport, dstRequisite);
        if (source.isPresent() && dest.isPresent()) {
            result = source.get().transfer(dest.get(), amount);
        }
        return result;

    }

    public String answer() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}