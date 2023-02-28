package domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    public static final String NOT_CONTAIN_NAME_ERROR = "[ERROR] 해당하는 이름이 없습니다.";
    public static final String ALL = "all";
    public static final String END = "end";

    private final List<User> users;

    public Users(List<String> userNames) {
        users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
    }

    public int getPersonCount() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public void checkNameInUsers(String nameInput) {
        if (!nameInput.equals(ALL) && !this.getUserNames().contains(nameInput) && !nameInput.equals(END)) {
            throw new IllegalArgumentException(NOT_CONTAIN_NAME_ERROR);
        }
    }
}
