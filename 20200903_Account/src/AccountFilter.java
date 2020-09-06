import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter {

    public List<Account> filter (List<Account> accounts, Predicate predicate){
        List<Account> newAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (predicate.test(account)) {
                newAccounts.add(account);
            }
        }
        return newAccounts;
    }
}
