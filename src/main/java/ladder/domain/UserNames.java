package ladder.domain;

import java.util.List;

public class UserNames {
    static final int MIN_SIZE = 2;
    static final int MAX_SIZE = 7;

    public UserNames(List<UserName> userNames) {
        validateSize(userNames);
    }

    private void validateSize(final List<UserName> userNames) {
        if (userNames.size() < MIN_SIZE || userNames.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
            ));
        }
    }
}
