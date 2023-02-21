package domain.player;

import utils.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 50;

    private final List<Player> players;

    public Players(List<String> playersName) {
        validateDuplicate(playersName);
        validateSize(playersName);
        this.players = createPlayers(playersName);
    }

    private List<Player> createPlayers(List<String> playersName) {
        return playersName.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> playersName) {
        Set<String> uniqueNames = new HashSet<>(playersName);

        if (uniqueNames.size() != playersName.size()) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateSize(List<String> playersName) {
        if (playersName.size() < MIN_PLAYER_SIZE || playersName.size() > MAX_PLAYER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_SIZE_ERROR.getMessage());
        }
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
