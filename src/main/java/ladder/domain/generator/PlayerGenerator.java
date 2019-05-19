package ladder.domain.generator;

import ladder.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class PlayerGenerator {
    protected static final String DELIMITER = ",";

    private final String playerNames;

    public PlayerGenerator(final String playerNames) {
        this.playerNames = playerNames;
    }

    public List<Player> generate() {
        List<Player> players = new ArrayList<>();
        String[] names = playerNames.split(DELIMITER);
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }
        return players;
    }
}
