package domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    private final List<User> users;

    public Users(final List<User> users) {
        validate(users);
        this.users = users;
    }

    public static Users of(String... usernames) {
        return new Users(Arrays.stream(usernames)
                .map(User::new)
                .toList());
    }

    public static Users fromNames(final List<String> userNames) {
        return new Users(userNames.stream()
                .map(User::new)
                .toList());
    }

    private void validate(final List<User> users) {
        validateLength(users);
        validateDuplicateName(users);
    }


    private void validateLength(final List<User> users) {
        if (users.size() <= 1) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최소 두명 이상이여야 합니다.", users.size()));
        }
        if (users.size() > 50) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사용자는 최대 50명입니다.", users.size()));
        }
    }

    private void validateDuplicateName(final List<User> users) {
        List<String> userNames = users.stream().map(User::toString).toList();
        List<String> uniqueUserNames = users.stream().map(User::toString).distinct().toList();
        if (userNames.size() != uniqueUserNames.size()) {
            throw new IllegalArgumentException("사용자 이름은 겹칠 수 없습니다.");
        }
    }

    public int size() {
        return users.size();
    }

    public int findPositionByName(final String name) {
        return IntStream.range(0, users.size())
                .filter(index -> name.equals(users.get(index).toString()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    @Override
    public String toString() {
        return users.stream().map(String::valueOf).collect(Collectors.joining(","));
    }
}
