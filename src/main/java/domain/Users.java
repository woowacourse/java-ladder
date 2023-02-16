package domain;

import static utils.ErrorMessage.NOT_FOUND_USER;

import java.util.List;

public class Users {
    private final int FIRST = 0;

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
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
