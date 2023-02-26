package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 26;

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerCount(players);
        validateDuplicatedNames(players);
        this.players = players;
    }

    private void validatePlayerCount(List<Player> players) {
        if (!isPlayerCountIncludedInRange(players.size())) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_PLAYER_COUNT.getMessage());
        }
    }

    private void validateDuplicatedNames(List<Player> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_DUPLICATED_NAME.getMessage());
        }
    }

    private boolean isPlayerCountIncludedInRange(int playerCount) {
        return MIN_PLAYER_COUNT <= playerCount && playerCount <= MAX_PLAYER_COUNT;
    }

    public Player findPlayer(Player givenPlayer) {
        Optional<Player> foundPlayer = Optional.ofNullable(players.stream()
                .filter(player1 -> player1.equals(givenPlayer))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_PLAYER_NAME.getMessage())));

        return foundPlayer.get();
    }

    public int findPositionOf(Player player) {
        return players.indexOf(player);
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

}
