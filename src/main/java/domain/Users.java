package domain;

import static domain.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.StringParser;

public class Users {
    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public int getUserCount() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(user -> StringParser.insertBlank(user.getName()))
                .collect(Collectors.toUnmodifiableList());
    }

    public User findUserByName(String userName) {
        return users.stream()
                .filter(user -> user.isEqualName(userName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NONE_EXISTED_USER.getMessage()));
    }

    public int getIndex(User user) {
        return users.indexOf(user);
    }
}
