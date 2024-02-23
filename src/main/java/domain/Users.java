package domain;

import java.util.List;

public class Users {

    private final List<UserName> users;

    public Users(final List<String> userNames) {
        validate(userNames);
        users = userNames.stream()
                .map(UserName::new)
                .toList();
    }

    public int gerPersonCount() {
        return users.size();
    }

    public UserName getFirst() {
        return users.get(0);
    }

    public UserName getLast() {
        return users.get(users.size() - 1);
    }

    public List<UserName> getMiddleUsers() {
        return users.subList(1, users.size() - 1);
    }

    private void validate(final List<String> userNames) {
        if (userNames.size() == 1) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 두명 이상이여야 합니다.", userNames.size()));
        }
        if (userNames.size() > 50) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 50명입니다.", userNames.size()));
        }
    }
}
