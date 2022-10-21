package taskOnLesson;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String username;
    private final List<Account> accountList = new ArrayList<>();

//    public User(String username) {
//        this.username = username;
//    }

    Faker faker = new Faker();

    public User() {
        username = faker.name().fullName();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(Account account) {
        accountList.add(account);
    }

    public String getUsername() {
        return username;
    }
}
