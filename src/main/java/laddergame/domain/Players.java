package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players from(final List<String> playerNames) {
        validate(playerNames);

        List<Player> players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        return new Players(players);
    }

    private static void validate(final List<String> playerNames) {
        checkBlankName(playerNames);
        checkDuplicated(playerNames);
    }

    private static void checkDuplicated(List<String> playerNames) {
        if (hasDuplicateName(playerNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkBlankName(List<String> playerNames) {
        if (playerNames.stream().anyMatch(String::isBlank)) {
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

    public List<Player> getPlayers() {
        return players;
    }
}
