package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class PlayerGenerator {
    public static final String DELIMITER = ",";

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
