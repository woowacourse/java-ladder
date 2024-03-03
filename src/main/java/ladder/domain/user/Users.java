package ladder.domain.user;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private static final int MIN_USER_SIZE = 2;
    private static final int MAX_USER_SIZE = 10;

    private final List<User> users;

    public Users(List<User> users) {
        validateUsersSize(users);
        validateDuplicatedUserName(users);
        this.users = users;
    }

    public int getSize() {
        return users.size();
    }

    public User getUserByIndex(int index) {
        return users.get(index);
    }

    private void validateUsersSize(List<User> usersToAdd) {
        if (usersToAdd.size() < MIN_USER_SIZE || usersToAdd.size() > MAX_USER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
        }
    }

    private void validateDuplicatedUserName(List<User> usersToAdd) {
        Set<String> distinctNames = usersToAdd.stream()
                .map(User::getUserName)
                .collect(Collectors.toSet());

        if (distinctNames.size() != usersToAdd.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 사용자명이 존재합니다.");
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
