package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final int USER_COUNT_MIN_RANGE = 2;
    private static final int USER_COUNT_MAX_RANGE = 10;
    private static final String INVALID_USER_COUNT_MESSAGE = "유저는 최소 2명 이상이다.";
    private static final String INVALID_SAME_USER_NAME_MESSAGE = "중복된 이름이 존재합니다.";
    private final List<User> users;

    public Users(List<String> users) {
        validateDuplicateName(users);
        validateUserCount(users);

        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private void validateUserCount(List<String> users) {
        if (users.size() < USER_COUNT_MIN_RANGE || users.size() > USER_COUNT_MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_USER_COUNT_MESSAGE);
        }
    }

    private void validateDuplicateName(List<String> users) {
        if (isDuplicateName(users)) {
            throw new IllegalArgumentException(INVALID_SAME_USER_NAME_MESSAGE);
        }
    }

    private boolean isDuplicateName(List<String> users) {
        return users.size() != users.stream()
                .distinct()
                .count();
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
