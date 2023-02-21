package domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int USER_COUNT_MIN_RANGE = 2;
    private static final int USER_COUNT_MAX_RANGE = 10;
    private static final String INVALID_USER_COUNT_MESSAGE = "유저는 2~10명 까지만 가능합니다.";
    private final List<User> users;

    public Users(List<User> users) {
        validateUserCount(users);
        this.users = users;
    }

    private void validateUserCount(List<User> users) {
        if (users.size() < USER_COUNT_MIN_RANGE || users.size() > USER_COUNT_MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_USER_COUNT_MESSAGE);
        }
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
