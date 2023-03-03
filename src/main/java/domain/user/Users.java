package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<String> userNames) {
        this.users = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            users.add(new User(userNames.get(i), i));
        }
    }

    public int getPersonCount() {
        return users.size();
    }

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        for (User user : users) {
            userNames.add(user.getName());
        }
        return userNames;
    }

    public User findUserByUserName(String userName) {
        return users.stream()
                .filter(user -> user.getName().equals(userName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
