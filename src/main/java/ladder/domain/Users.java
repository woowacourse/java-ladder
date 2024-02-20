package ladder.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        validateUsers(users);
        this.users = users;
    }

    private void validateUsers(List<User> users) {
        validateUsersSize(users);
        validateDuplicatedUserName(users);
    }

    private void validateUsersSize(List<User> users) {
        if (users.size() < 2 || users.size() > 10) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
        }
    }

    private void validateDuplicatedUserName(List<User> users) {
        Set<String> distinctNames = users.stream()
                .map(User::getUserName)
                .collect(Collectors.toSet());

        if (distinctNames.size() != users.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 사용자명이 존재합니다.");
        }
    }
}
