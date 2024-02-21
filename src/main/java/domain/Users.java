package domain;

import java.util.List;

public class Users {

    private final List<UserName> users;

    public Users(final List<String> userNames) {
        users = userNames.stream()
                .map(UserName::new)
                .toList();
        validate();
    }

    public int gerPersonCount() {
        return users.size();
    }

    private void validate() {
        if (users.size() == 1) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 두명 이상이여야 합니다.", users.size()));
        }
        if (users.size() > 50) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 50명입니다.", users.size()));
        }
    }
}
