package laddergame.domain;

import java.util.List;
import java.util.Set;

public class Players {
    public Players(final List<String> playerNames) {
        validate(playerNames);
    }

    private void validate(final List<String> playerNames) {
        if (playerNames.size() != Set.of(playerNames).size()) {
            throw new IllegalArgumentException();
        }
    }
}
