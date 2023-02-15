package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        users = new ArrayList<>();
        for (final String userName : userNames) {
            users.add(new User(userName));
        }
    }

    public int size() {
        return users.size();
    }

    public List<String> getUsersName() {
        final List<String> usersName = new ArrayList<>();
        for (final User user : users) {
            usersName.add(user.getName());
        }
        return usersName;
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
        }
    }
}
