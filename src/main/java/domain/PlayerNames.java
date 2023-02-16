package domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {

    private static final int PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE = 2;
    private static final int PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = 20;

    public static final String PLAYER_NUMBER_RANGE_ERROR_MESSAGE = "참여자 수는 2 ~ 20명만 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATION_ERROR_MESSAGE = "이름은 중복될 수 없습니다.";
    private final List<Name> names;

    private PlayerNames(List<Name> names) {
        validate(names);
        this.names = names;
    }

    public static PlayerNames from(List<String> playerNames) {
        List<Name> names = playerNames.stream()
                .map(Name::new)
                .collect(Collectors.toList());

        return new PlayerNames(names);
    }

    private void validate(List<Name> names) {
        validateDuplication(names);
        validatePlayerNumber(names.size());
    }

    private void validateDuplication(List<Name> names) {
        int duplicationSize = names.stream()
                .map(Name::getName)
                .collect(Collectors.toSet())
                .size();

        if (duplicationSize != names.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validatePlayerNumber(int playerNumber) {
        if (isOutOfRange(playerNumber)) {
            throw new IllegalArgumentException(PLAYER_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isOutOfRange(int playerNumber) {
        return !(PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE <= playerNumber
                && playerNumber <= PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    public List<Name> getNames() {
        return this.names;
    }

}
