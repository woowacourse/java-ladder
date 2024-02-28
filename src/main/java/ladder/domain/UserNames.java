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

    public static UserNames from(final List<String> userNames) throws IllegalArgumentException {
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

    public boolean isExist(final String name) {
        return userNames.stream()
                .anyMatch(userName -> userName.isSame(name));
    }

    public UserName findByOrder(final int order) {
        if (order < 0 || order >= userNames.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 값입니다.");
        }
        return userNames.get(order);
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
