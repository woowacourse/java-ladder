package domain;

import java.util.Arrays;
import java.util.List;

public class Users {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public int gerPersonCount() {
        return users.size();
    }

    public Users() {

    }

    public Users(String userNames) {
        String[] splitUserNames = userNames.split(",");
        users = Arrays.stream(splitUserNames).map(User::new).toList();
    }
}
