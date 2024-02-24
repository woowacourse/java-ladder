package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Users {
    private final List<UserName> users;

    public Users(final List<String> userNames) {
        validate(userNames);
        users = userNames.stream()
                .map(UserName::new)
                .toList();
    }

    private void validate(final List<String> userNames) {
        if (userNames.size() <= 1) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 두명 이상이여야 합니다.", userNames.size()));
        }
        if (userNames.size() > 50) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 50명입니다.", userNames.size()));
        }
    }

    public int getPersonCount() {
        return users.size();
    }

    public List<UserName> getUsers() {
        return users;
    }

    public int findPositionByName(String name) {
        return IntStream.range(0, users.size())
                .filter(index -> name.equals(users.get(index).toString()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }
}
