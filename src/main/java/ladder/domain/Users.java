package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final int MINIMUM_SIZE = 2;
    private static final String USERS_SIZE_ERROR_MESSAGE = "유저는 한명보다 많아야 합니다.";
    private static final String USERS_DUPLICATED_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다.";
    private final List<User> users;

    public Users(List<String> userNames) {
        validate(userNames);
        List<User> collect = userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
        this.users = new ArrayList<>(collect);
    }

    private void validate(List<String> userNames) {
        validateDuplication(userNames);

        validateSize(userNames);
    }

    private void validateSize(List<String> userNames) {
        if (userNames.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(USERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<String> userNames) {
        if (userNames.size() != getUnDuplicationNamesSize(userNames)) {
            throw new IllegalArgumentException(USERS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private long getUnDuplicationNamesSize(final List<String> userNames) {
        return userNames.stream()
                .distinct()
                .count();
    }

    public List<User> getUsers() {
        return users;
    }
}
