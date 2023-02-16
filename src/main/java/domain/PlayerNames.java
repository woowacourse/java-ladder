package domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {

    private static final String PLAYER_NAME_DUPLICATION_ERROR_MESSAGE = "이름은 중복될 수 없습니다.";
    private final List<Name> names;

    private PlayerNames(List<Name> names) {
        this.names = names;
    }

    public static PlayerNames from(List<String> playerNames) {
        validate(playerNames);
        List<Name> names = playerNames.stream()
                .map(Name::new)
                .collect(Collectors.toList());

        return new PlayerNames(names);
    }

    private static void validate(List<String> names) {
        int duplicationSize = new HashSet<>(names).size();

        if (duplicationSize != names.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

}
