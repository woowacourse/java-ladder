package service;

import domain.User;
import domain.Users;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final Users users;

    public UserService(List<String> userNames) {
        this.users = initializeUsers(userNames);
    }

    private Users initializeUsers(List<String> userNames) {
        List<User> users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
        return new Users(users);
    }

    public Users getUsers() {
        return users;
    }
}
