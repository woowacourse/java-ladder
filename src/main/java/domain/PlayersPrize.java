package domain;

import java.util.Collections;
import java.util.Map;

public class PlayersPrize {
    private final Map<Player, Prize> playersPrize;

    public PlayersPrize(final Map<Player, Prize> playersPrize) {
        this.playersPrize = playersPrize;
    }

    public Prize search(String command) {
        return playersPrize.get(new Player(command));
    }

    public Map<Player, Prize> getPlayersPrize() {
        return Collections.unmodifiableMap(playersPrize);
    }
}
