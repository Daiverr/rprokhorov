package ru.job4j.bankmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankSystem {
    HashMap<User, List<Account>> base = new HashMap<>();

    public void addUser(User user) {
        base.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        base.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user: base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user: base.keySet()) {
            if (user.getPassport().equals(passport)) {
                base.get(user).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        for (User user: base.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = base.get(user);
            }
        }
        return result;
    }

    public Account getAccountFromList(String passport, String requisite) {
        Account result = null;
        for (Account account: this.getUserAccounts(passport)) {
            if (account.getRequisites().equals(requisite)) {
                result = account;
            }
        }
            return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account src = this.getAccountFromList(srcPassport, srcRequisite);
        Account dest = this.getAccountFromList(destPassport, dstRequisite);
        if (src.getValue() - amount >= 0) {
            dest.addMoney(amount);
            src.takeMoney(amount);
            result = true;
        }
        return result;
    }
}
