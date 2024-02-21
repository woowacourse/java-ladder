package laddergame.domain;

import java.util.List;
import java.util.Set;

public class Players {
    private final List<String> playerNames;

    public Players(final List<String> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames;
    }

    private void validate(final List<String> playerNames) {
        if (playerNames.size() != Set.of(playerNames).size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
