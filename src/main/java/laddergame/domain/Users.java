package laddergame.domain;

import static laddergame.utils.ErrorMessage.NOT_FOUND_USER;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private static final int FIRST = 0;
    private static final String ALL = "all";

    private final List<User> users;

    public Users(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public void validateResultCheckCommand(String name) {
        boolean isNotExist = users.stream()
                .noneMatch(user -> user.getName().equals(name));
        if (!name.equals(ALL) && isNotExist) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }

    private void validateFirstUser() {
        if (users.isEmpty()) {
            throw new NullPointerException(NOT_FOUND_USER.getMessage());
        }
    }

    public int count() {
        return users.size();
    }

    public String getFirstUserName() {
        validateFirstUser();
        return users.get(FIRST).getName();
    }

    public List<User> getUsers() {
        return users;
    }

}
