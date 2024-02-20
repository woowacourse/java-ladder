package ladder.domain;

import java.util.List;

public class UserNames {
    static final int MIN_SIZE = 2;
    static final int MAX_SIZE = 7;

    public UserNames(List<UserName> userNames) {
        validateSize(userNames);
        validateDuplicate(userNames);
    }

    private void validateSize(final List<UserName> userNames) {
        if (userNames.size() < MIN_SIZE || userNames.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
            ));
        }
    }

    private void validateDuplicate(final List<UserName> userNames) {
        long unique = userNames.stream()
                .distinct()
                .count();

        if (userNames.size() != unique) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }
}
