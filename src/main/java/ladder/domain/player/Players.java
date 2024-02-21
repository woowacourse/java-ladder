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

    public Players(final List<String> playerNames) {
        validatePlayers(playerNames);
        this.players = createPlayers(playerNames);
    }

    private static List<Player> createPlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validatePlayers(final List<String> playerNames) {
        validateSize(playerNames);
        validateDuplicatedName(playerNames);
    }

    private void validateSize(final List<String> playerNames) {
        final int playerSize = playerNames.size();

        if (playerSize > MAXIMUM_PLAYER_SIZE || playerSize < MINIMUM_PLAYER_SIZE) {
            throw new InvalidInputException(ErrorMessage.INVALID_PLAYER_SIZE);
        }
    }

    private void validateDuplicatedName(final List<String> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATED_PLAYER_NAME);
        }
    }


    public int countPlayers() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
