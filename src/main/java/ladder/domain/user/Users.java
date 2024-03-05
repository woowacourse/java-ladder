package ladder.domain.user;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ladder.util.BaseException;

public class Users {

    private static final int MIN_USER_SIZE = 2;
    private static final int MAX_USER_SIZE = 10;

    private final List<User> users;

    public Users(List<User> users) {
        validateUsers(users);
        this.users = users;
    }

    public void validateExistUserName(String name) {
        List<String> userNames = getUsersNames();
        if (!userNames.contains(name)) {
            throw new BaseException("존재하지 않는 사용자의 이름입니다.");
        }
    }

    private void validateUsers(List<User> users) {
        validateUsersSize(users);
        validateDuplicatedUserName(users);
    }

    private void validateUsersSize(List<User> users) {
        if (users.size() < MIN_USER_SIZE || users.size() > MAX_USER_SIZE) {
            throw new BaseException("사용자는 2~10명 까지만 등록 가능합니다.");
        }
    }

    private void validateDuplicatedUserName(List<User> users) {
        Set<String> distinctNames = users.stream()
                .map(User::getUserName)
                .collect(Collectors.toSet());

        if (distinctNames.size() != users.size()) {
            throw new BaseException("중복된 사용자명이 존재합니다.");
        }
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public List<String> getUsersNames() {
        return this.users.stream()
                .map(User::getUserName)
                .collect(Collectors.toList());
    }
}
