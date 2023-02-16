package domain;

import java.util.List;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getFirstUserName() {
        if (users.isEmpty()) {
            throw new NullPointerException("유저가 존재하지 않습니다.");
        }
        return users.get(0).getName();
    }
}
