package domain.result;

import domain.player.Player;
import domain.prize.Prize;
import java.util.Collections;
import java.util.Map;

public class PlayersPrize {
    private final Map<Player, Prize> playersPrize;

    public PlayersPrize(final Map<Player, Prize> playersPrize) {
        this.playersPrize = playersPrize;
    }

    public Prize search(String playerName) {
        return playersPrize.get(new Player(playerName));
    }

    public Map<Player, Prize> getPlayersPrize() {
        return Collections.unmodifiableMap(playersPrize);
    }
}
