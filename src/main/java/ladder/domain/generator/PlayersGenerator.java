package ladder.domain.generator;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.ArrayList;
import java.util.List;

public final class PlayersGenerator {
    protected static final String DELIMITER = ",";

    private final String playerNames;

    public PlayersGenerator(final String playerNames) {
        this.playerNames = playerNames;
    }

    public Players generate() {
        List<Player> players = new ArrayList<>();
        String[] names = playerNames.split(DELIMITER);
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i], i));
        }
        return new Players(players);
    }
}
