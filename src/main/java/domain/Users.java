package domain;


import static utils.ErrorMessage.NOT_FOUND_USER;

import java.util.List;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public User findUser(String name) {
        return users.stream()
            .filter(user -> user.getName().equals(name))
            .findAny()
            .orElseThrow();
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

    private void validateFirstUser() {
        if (users.isEmpty()) {
            throw new IllegalArgumentException(NOT_FOUND_USER.getMessage());
        }
    }

    public String getFirstUserName() {
        validateFirstUser();
        return users.get(FIRST).getName();
    }

    public List<User> getUsers() {
        return users;
    }

}
