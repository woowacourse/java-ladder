package domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static utils.ErrorMessage.*;

public class Users {
    private static final int MINIMUM_USER_NUMBER = 1;
    private static final int MAXIMUM_USER_NUMBER = 20;

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users from(List<String> usernames) {
        validateUsernameDuplication(usernames);
        validateUsersNumber(usernames);

        List<User> users = IntStream.range(0, usernames.size())
                .mapToObj(i -> User.of(
                Name.from(usernames.get(i)), Position.from(i)))
                .collect(Collectors.toList());
        return new Users(users);
    }

    public User findUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER.getMessage()));
    }

    public void moveUsers(List<List<Integer>> allNumbers) {
        for (User user : users) {
            moveUser(allNumbers, user);
        }
    }

    private void moveUser(List<List<Integer>> allNumbers, User user) {
        for (List<Integer> numbers : allNumbers) {
            user.movePosition(numbers);
        }
    }

    private static void validateUsersNumber(List<String> allUsernames) {
        if (allUsernames.size() < MINIMUM_USER_NUMBER || allUsernames.size() > MAXIMUM_USER_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(
                            INVALID_USER_NUMBER.getMessage(),
                            MINIMUM_USER_NUMBER, MAXIMUM_USER_NUMBER));
        }
    }

    private static void validateUsernameDuplication(List<String> allUsernames) {
        if (allUsernames.size() != checkDistinctSize(allUsernames)) {
            throw new IllegalArgumentException(
                    DUPLICATE_USERNAME.getMessage());
        }
    }

    private static long checkDistinctSize(List<String> allUsernames) {
        return allUsernames.stream()
                .distinct()
                .count();
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

}
