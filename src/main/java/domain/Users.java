package domain;


import static utils.ErrorMessage.NOT_FOUND_USER;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users from(List<String> userNames) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            users.add(User.of(
                    Name.from(userNames.get(i)),
                    Position.from(i)));
        }

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

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

}
