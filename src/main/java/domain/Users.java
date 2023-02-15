package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.StringParser;

public class Users {
    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public int getSize() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(user -> StringParser.insertBlank(user.getName()))
                .collect(Collectors.toUnmodifiableList());
    }
}
