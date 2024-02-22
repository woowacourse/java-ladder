package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {
    static final int MIN_SIZE = 2;

    private final List<UserName> userNames;

    private UserNames(final List<UserName> userNames) {
        validateSize(userNames);
        validateDuplicate(userNames);
        this.userNames = userNames;
    }

    public static UserNames of(final List<String> userNames) throws IllegalArgumentException {
        List<String> names = new ArrayList<>(userNames);
        return names.stream()
                .map(UserName::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), UserNames::new));
    }

    private void validateSize(final List<UserName> userNames) throws IllegalArgumentException {
        if (userNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "참여자는 %d명 이상이어야 합니다.", MIN_SIZE
            ));
        }
    }

    private void validateDuplicate(final List<UserName> userNames) throws IllegalArgumentException {
        long unique = userNames.stream()
                .distinct()
                .count();

        if (userNames.size() != unique) {
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
