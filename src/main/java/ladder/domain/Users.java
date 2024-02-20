package ladder.domain;

import java.util.List;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        validateUsersSize(users);
        this.users = users;
    }

    private void validateUsersSize(List<User> users) {
        if (users.size() < 2 || users.size() > 10) {
            throw new IllegalArgumentException("[ERROR] 사용자는 2~10명 까지만 등록 가능합니다.");
        }
    }
}
