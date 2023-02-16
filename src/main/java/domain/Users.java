package domain;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) { // 구현
        if (users.size() < 2 || users.size() > 10) {
            throw new IllegalArgumentException("유저는 최소 2명 이상이다.");
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
