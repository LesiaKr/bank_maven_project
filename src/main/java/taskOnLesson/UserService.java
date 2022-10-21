package taskOnLesson;

import java.util.List;

public interface UserService<A extends Account, U extends User> {
    List<String> printAllUsers();
    List<Account> printAllAccount();
    double countTax(A account);
    User userCreate();
}
