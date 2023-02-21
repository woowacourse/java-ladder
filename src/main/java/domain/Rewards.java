package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private static final String INVALID_REWARDS_SIZE = "실행 결과의 수는 참여자 수와 동일해야 합니다.";
    private final List<Name> names;

    public Rewards(final List<String> names, final int playerSize) {
        validate(names, playerSize);
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> names, final int playerSize) {
        validateNames(names, playerSize);
    }

    private void validateNames(final List<String> names, final int playerSize) {
        if (names.size() != playerSize) {
            throw new IllegalArgumentException(INVALID_REWARDS_SIZE);
        }
    }

    public Name getReward(final int index) {
        return names.get(index);
    }
}
