package model.players;

import static exception.Message.INVALID_PLAYER_ERROR;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Players {

    private static final int MIN_PLAYERS = 2;

    private final List<Player> players;

    public Players(List<String> players) {
        Validator.validate(players);
        this.players = convert(players);
    }

    private List<Player> convert(List<String> players) {
        return players.stream()
                .map(Player::new)
                .toList();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public Position findPositionByName(final String name) {
        return IntStream.range(0, players.size())
                .filter(index -> isPlayerNameMatch(name, index))
                .mapToObj(Position::new)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_ERROR.getMessage()));
    }

    private boolean isPlayerNameMatch(final String name, final int index) {
        return players.get(index).getName().equals(name);
    }

    public Player findByName(final String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_ERROR.getMessage()));
    }

    public int size() {
        return players.size();
    }

    private static class Validator {
        public static void validate(List<String> players) {
            validateSize(players);
            validateDuplicates(players);
        }

        private static void validateSize(List<String> players) {
            if (players.size() < MIN_PLAYERS) {
                throw new IllegalArgumentException(INVALID_PLAYER_ERROR.getMessage());
            }
        }

        private static void validateDuplicates(List<String> players) {
            if (isDuplicated(players)) {
                throw new IllegalArgumentException(INVALID_PLAYER_ERROR.getMessage());
            }
        }

        private static boolean isDuplicated(List<String> players) {
            return Set.copyOf(players).size() != players.size();
        }
    }
}
