package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.StringParser;

public class Users {

    private final List<User> users;

    public Users(final List<User> users) {
        validate(users);
        this.users = List.copyOf(users);
    }

    private void validate(final List<User> users) {
        Set<User> notDuplicatedUsers = new HashSet<>(users);
        if (users.size() != notDuplicatedUsers.size()) {
            throw new IllegalArgumentException();
        }
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
