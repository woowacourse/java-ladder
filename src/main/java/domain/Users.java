package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Users {

    private final List<User> users = new ArrayList<>();

    public Users(final List<String> userNames) {
        validateUserNamesEmpty(userNames);
        for (int index = 0; index < userNames.size(); index++) {
            users.add(new User(userNames.get(index), index));
        }
    }

    private void validateUserNamesEmpty(final List<String> userNames) {
        if (userNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USERS_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    public List<String> getUserNames() {
        final List<String> usersName = new ArrayList<>();
        for (final User user : users) {
            usersName.add(user.getName());
        }
        return usersName;
    }

    public void swapUserPositionBy(final int position) {
        final User userA = users.get(position);
        final User userB = users.get(position + 1);
        userA.swapPosition(userB);
    }

    public int size() {
        return users.size();
    }

    public void validateParticipateUser(final String userName) {
        final Optional<User> findUser = users.stream()
                .filter(user -> user.isSameName(userName))
                .findFirst();
        if (findUser.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NOT_FOUND_EXCEPTION.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
