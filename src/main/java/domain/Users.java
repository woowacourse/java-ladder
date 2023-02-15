package domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<String> userNames) {
        if (userNames.size() == 0) {
            throw new IllegalArgumentException("");
        }
        users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
    }

    public int size() {
        return users.size();
    }
}
