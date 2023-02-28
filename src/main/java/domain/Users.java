package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import utils.StringParser;

public class Users {

    private static final String DUPLICATED_USER_ERROR = "[ERROR] 사람의 이름은 중복될 수 없습니다.";
    private static final String NOT_EXIST_USER_ERROR = "[ERROR] 해당 이름을 가진 사람은 존재하지 않습니다.";

    private final List<User> users;

    public Users(final List<User> users) {
        validate(users);
        this.users = List.copyOf(users);
    }

    private void validate(final List<User> users) {
        Set<User> notDuplicatedUsers = new HashSet<>(users);
        if (users.size() != notDuplicatedUsers.size()) {
            throw new IllegalArgumentException(DUPLICATED_USER_ERROR);
        }
    }

    public User findByName(final String name) {
        return users.stream()
                .filter(Objects::nonNull)
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_USER_ERROR));
    }

    public int getSize() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(user -> StringParser.insertBlank(user.getName()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<User> getUsers() {
        return users;
    }
}
