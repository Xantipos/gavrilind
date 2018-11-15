package ru.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<Account>());
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

    public User findUserByPassport(String passport) {
        User result = new User();
        for (User us : treemap.keySet()) {
            if  (us.getPassport().equals(passport)) {
                result = us;
            }
        }
        return result;
    }

    public User findUserByReq(String Requisite) {
        Account targetAccount = new Account(0,"");
        User result = new User();

        for ( ArrayList<Account> acc : treemap.values()) {
            for (Account accountUser : acc) {
                if (accountUser.getReqs() == Requisite) {
                    targetAccount = accountUser;
                }
            }
        }
        for (User us : treemap.keySet()) {
            ArrayList<Account> listAccountUser = this.treemap.get(us);
            for (Account accountOfUser : listAccountUser) {
                if(accountOfUser == targetAccount) {
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
        Account result = new Account(0,"0");
        for (Account acc : getAccounts(findUserByPassport(passport))) {
            if (acc.getReqs() == requisite) {
                result = acc;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        //User usersrc = findUserByPassport(srcPassport);
        //User userdst = findUserByPassport(destPassport);
        List<Account> listsrc = getUserAccounts(srcPassport);
        List<Account> listdest = getUserAccounts(destPassport);
        Account source = getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite);
        Account destination = getAccountByRequisiteFromUserPassport(destPassport, dstRequisite);
        if(listsrc.contains(source) & listdest.contains(destination)){
           result = source.transfer(destination, amount);

        }
        return result;
    }

    public String answer() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}