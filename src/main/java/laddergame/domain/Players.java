package laddergame.domain;

import java.util.List;

public class Players {
    private final List<String> playerNames;

    private Players(final List<String> playerNames) {
        this.playerNames = playerNames;
    }

    public static Players from(final List<String> playerNames) {
        validate(playerNames);
        return new Players(playerNames);
    }

    private static void validate(final List<String> playerNames) {
        if (hasDuplicateName(playerNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasDuplicateName(final List<String> carNames) {
        return carNames.size() != getDistinctNamesCount(carNames);
    }

    private static long getDistinctNamesCount(final List<String> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
