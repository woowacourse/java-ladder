package domain;

import static utils.ErrorMessage.NOT_FOUND_USER;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int FIRST = 0;

    private final List<User> users;

    public Users(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public List<User> getUsers() {
        return users;
    }

    public int count() {
        return users.size();
    }

    public String getFirstUserName() {
        validateFirstUser();
        return users.get(FIRST).getName();
    }

    private void validateFirstUser() {
        if (users.isEmpty()) {
            throw new NullPointerException(NOT_FOUND_USER.getMessage());
        }
    }
}
