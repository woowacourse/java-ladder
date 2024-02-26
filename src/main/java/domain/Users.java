package domain;

import java.util.List;

public class Users {

    private static final int MIN_USER_SIZE = 2;
    private static final int MAX_USER_SIZE = 50;
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
        if (userNames.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 %d명 이상이여야 합니다.", userNames.size(), MIN_USER_SIZE));
        }
        if (userNames.size() > MAX_USER_SIZE) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 %d명입니다.", userNames.size(), MAX_USER_SIZE));
        }
    }
}
