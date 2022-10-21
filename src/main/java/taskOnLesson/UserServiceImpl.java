package taskOnLesson;

import java.util.*;

class UserServiceImpl<A extends Account, U extends User> implements UserService<A,U>{

    private final Map<User, List<Account>> usersMap = new HashMap<>();
    private final List<String> usersList = new ArrayList<>();
    private final List<Account> accountLists = new ArrayList<>();

    public void addAccount(User user, Account account) {
        user.setAccountList(account);
        usersMap.put(user, user.getAccountList());
    }
//показати всіх користувачів(посортованих по user name)
    @Override
    public List<String> printAllUsers() {
        for (Map.Entry<User, List<Account>> entry : usersMap.entrySet()) {
            usersList.add(entry.getKey().getUsername());
        }
        Collections.sort(usersList);

        for (String userName : usersList) {
            System.out.println(userName);
        }
        return usersList;
    }
//показати всі рахунки
    @Override
    public List<Account> printAllAccount() {
//        for (Account userAcc : accountLists) {
//            System.out.println(userAcc);
//        }
        for (Map.Entry<User, List<Account>> user : usersMap.entrySet()) {
            System.out.println("\n" + user.getKey().getUsername() + " has accounts:\n" + user.getValue());
        }
        return accountLists;
    }
//повернути кількість податку для людини
    @Override
    public double countTax(Account account) throws IndexOutOfBoundsException{
        return account.getSum() * 0.05;
    }

//створюється новий user рандомно
    @Override
    public User userCreate() {
        return new User();
    }
}
