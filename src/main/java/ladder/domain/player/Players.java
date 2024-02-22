package ladder.domain.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class Players {
    public static final int MAXIMUM_PLAYER_SIZE = 10;
    public static final int MINIMUM_PLAYER_SIZE = 2;
    private final List<Player> players;

    public Players(final List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(final List<Player> players) {
        validateSize(players);
        validateDuplicatedName(players);
    }

    private void validateSize(final List<Player> players) {
        final int playerSize = players.size();

        if (MINIMUM_PLAYER_SIZE < playerSize || playerSize < MAXIMUM_PLAYER_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_SIZE);
        }
    }

    private void validateDuplicatedName(final List<Player> players) {
        final List<String> playerNames = players.stream()
                .map(Player::getName)
                .toList();

        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATED_PLAYER_NAME);
        }
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
