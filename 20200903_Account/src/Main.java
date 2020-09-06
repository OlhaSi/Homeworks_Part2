import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Account account1 = new Account("dfhd22", 2000, false);
        Account account2 = new Account("dt2", 400, true);
        Account account3 = new Account("3", 100002, false);
        Account account4 = new Account("4", 0, true);
        Account account5 = new Account("5", -1000, false);

        List<Account> accounts = Arrays.asList(account1, account2, account3, account4, account5);

        Predicate<Account> getBalance = account -> account.getBalance() > 0;
        Predicate<Account> isLocked = Account::isLocked;
        Predicate<Account> largeBalance = account -> account.getBalance() > 100000;

        AccountFilter filter = new AccountFilter();
        System.out.println(filter.filter(accounts, getBalance));
        System.out.println(filter.filter(accounts, isLocked.negate().and(largeBalance)));

    }
}
