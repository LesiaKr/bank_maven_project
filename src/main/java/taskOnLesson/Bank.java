package taskOnLesson;

/*Написати структуру Банк :
Створити клас Account, від нього унаслідувати різні типи акаунтів :
DebitAccount(в нього поле Id є стрінговим), CreditAccount (в нього поле Id є числовим).
Створити клас User. Створити параметризований інтерфейс - User service, який буде в якості
параметра приймати Account(та наслідників) та User і буде мати наступні методи :
- показати всіх користувачів(посортованих по user name)
- показати всі рахунки
- повернути кількість податку для людини, яка розраховується як загальну суму на рахунку * 0,05*/
public class Bank{
    public static void main(String[] args) {

        UserServiceImpl<Account, User> userService = new UserServiceImpl();

//        User user1 = new User();
        userService.addAccount(userService.userCreate(), new DebitAccount("first", 5000));
        userService.addAccount(userService.userCreate(), new CreditAccount(1, 4000));
        userService.addAccount(userService.userCreate(), new DebitAccount("third", 6000));
        userService.addAccount(userService.userCreate(), new CreditAccount(3, 3000));

//створюю спільного юзера для двох аккаунтів
        User users = userService.userCreate();
        userService.addAccount(users, new DebitAccount("second", 3000));
        userService.addAccount(users, new CreditAccount(2, 2000));

        userService.printAllUsers();
        userService.printAllAccount();

        System.out.println("\nThe amount of tax for: " + users.getUsername() + " "
                + userService.countTax(users.getAccountList().get(0)));
//        System.out.println("The amount of tax for: " + userService.userCreate().getUsername() + " "
//                + userService.countTax(userService.userCreate().getAccountList().get(0)));
//        System.out.println("The amount of tax for: " + userService.userCreate().getUsername() + " "
//                + userService.countTax(userService.userCreate().getAccountList().get(0)));
//        //System.out.println(userService.countTax());
//        userService.countTax((Account) userService.userCreate().getAccountList());
    }
}
