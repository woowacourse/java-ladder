package ladder.domain.generator;

import ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class PlayerGenerator {
    private static final String DELIMITER = ",";

    private final String playerNames;

    public PlayerGenerator(final String playerNames) {
        this.playerNames = playerNames;
    }

    public List<Player> generate() {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
