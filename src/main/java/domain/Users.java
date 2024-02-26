package domain;

import java.util.List;

public class Users {

    private static final int MIN_USER_SIZE = 2;
    private static final int MAX_USER_SIZE = 50;
    private final List<UserName> userNames;

    public Users(final List<String> userNames) {
        validate(userNames);
        this.userNames = userNames.stream()
                .map(UserName::new)
                .toList();
    }

    public int gerPersonCount() {
        return userNames.size();
    }

    public UserName getFirst() {
        return userNames.get(0);
    }

    public UserName getLast() {
        return userNames.get(userNames.size() - 1);
    }

    public List<UserName> getMiddleUsers() {
        return userNames.subList(1, userNames.size() - 1);
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
