package ru.job4j.collections.bank;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (this.users.putIfAbsent(user, new ArrayList<>()) == null) {
            System.out.println("The User inserted successfully");
        } else {
            System.out.println("This User already exists");
        }

    }

    public void deleteUser(User user) {
        if (this.users.remove(user) != null) {
            System.out.println("The user successfully deleted");
        } else {
            System.out.println("Such a user does not exist");
        }
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.users.get(user).add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.users.get(user).remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = null;

        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                accounts = this.users.get(user);
                break;
            }
        }
        return accounts;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                 long amount) {
        Boolean result = false;
        User userSrc = null;
        User userDst = null;

        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(srcPassport)) {
                userSrc = user;
            }
            if (user.getPassport().equals(destPassport)) {
                userDst = user;
            }
        }
        Integer indexAccountSrc = null;
        Integer indexAccountDst = null;

        if ((userSrc != null) && (userDst != null)) {
            for (Account account : this.users.get(userSrc)) {
                if (account.getRequisites().equals(srcRequisite)) {
                    indexAccountSrc = this.users.get(userSrc).indexOf(account);
                }
            }
            for (Account account : this.users.get(userDst)) {
                if (account.getRequisites().equals(dstRequisite)) {
                    indexAccountDst = this.users.get(userDst).indexOf(account);
                }
            }
        }
        if ((indexAccountSrc != null) && (indexAccountDst != null)) {
            result = this.users.get(userSrc).get(indexAccountSrc).transfer(this.users.get(userDst).get(indexAccountDst),
                    amount);
        }
        return result;
    }

    public Map<User, List<Account>> getUsers() {
        return users;
    }
}