package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UserNames {
    static final int MIN_SIZE = 2;
    static final int MAX_SIZE = 7;

    private final List<UserName> userNames;

    private UserNames(List<UserName> userNames) {
        validateSize(userNames);
        validateDuplicate(userNames);
        this.userNames = userNames;
    }

    public static UserNames of(List<String> names) {
        return names.stream()
                .map(UserName::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), UserNames::new));
    }

    private void validateSize(final List<UserName> userNames) {
        if (userNames.size() < MIN_SIZE || userNames.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
            ));
        }
    }

    private void validateDuplicate(final List<UserName> userNames) {
        long uniqueUserNamesCount = userNames.stream()
                .distinct()
                .count();

        if (userNames.size() != uniqueUserNamesCount) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }

    public int getUserCount() {
        return userNames.size();
    }

    public List<String> getUserNames() {
        return userNames.stream()
                .map(UserName::value)
                .toList();
    }
}
