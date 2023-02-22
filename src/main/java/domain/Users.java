package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private final List<User> users;

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        this.users = initUsers(userNames);
    }

    public int size() {
        return users.size();
    }

    public void isExist(String userName) {
        List<String> usersName = getUsersName();
        if (usersName.contains(userName)) {
            return;
        }
        throw new IllegalArgumentException();
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
            throw new IllegalArgumentException(ErrorMessage.USER_NAMES_BLANK_EXCEPTION.getMessage());
        }
    }

    private List<User> initUsers(List<String> userNames) {
        final List<User> users = new ArrayList<>();
        for (final String userName : userNames) {
            users.add(new User(userName));
        }
        return users;
    }
}
