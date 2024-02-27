package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    static final int MIN_SIZE = 2;
    static final int MAX_SIZE = 7;

    private final List<PlayerName> playerNames;

    private PlayerNames(List<PlayerName> playerNames) {
        validateSize(playerNames);
        validateDuplicate(playerNames);
        this.playerNames = playerNames;
    }

    public static PlayerNames of(List<String> names) {
        return names.stream()
                .map(PlayerName::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), PlayerNames::new));
    }

    private void validateSize(final List<PlayerName> playerNames) {
        if (playerNames.size() < MIN_SIZE || playerNames.size() > MAX_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
            ));
        }
    }

    private void validateDuplicate(final List<PlayerName> playerNames) {
        long uniqueUserNamesCount = playerNames.stream()
                .distinct()
                .count();

        if (playerNames.size() != uniqueUserNamesCount) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }

    public int getPlayerCount() {
        return playerNames.size();
    }

    public List<String> getPlayerNames() {
        return playerNames.stream()
                .map(PlayerName::value)
                .toList();
    }
}
