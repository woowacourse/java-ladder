package domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int USER_COUNT_MIN_RANGE = 1;
    private static final int USER_COUNT_MAX_RANGE = 10;
    private static final String INVALID_USER_COUNT_MESSAGE = "유저는 최소 2명 이상이다.";
    private final List<User> users;

    public Users(List<User> users) { // 구현
        if (users.size() < USER_COUNT_MIN_RANGE || users.size() > USER_COUNT_MAX_RANGE) {
            throw new IllegalArgumentException(INVALID_USER_COUNT_MESSAGE);
        }
        this.users = users;
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
