package ru.job4j.collections.codeReview;



// много пустых строк, лишнии пробелы перед импортами

        import ru.job4j.collections.User;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.TreeMap;


public class Bank {

    /* обычно стараются везде использовать интерфейсы для того, чтобы
    * вслучае необходимости можно было например без переписывания основного кода TreeMap заменить на HashMap,
    * название переменной не по code conventions правильное наименование treeMap
    */
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<Account>());
    }

    public void delete(User user) {
        this.treemap.remove(user);
    }

    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    /* тело метода можно заменить на return this.treemap.get(user).get(list.indexOf(account));
       * без объявления переменной
       */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    // не корректно переопределен метод, вернет не аккаунты, а ссылку переменной treemap
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}
