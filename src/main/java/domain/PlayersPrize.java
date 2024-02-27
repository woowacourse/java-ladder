package domain;

import java.util.Map;

public class PlayersPrize {
    private final Map<Player, Prize> playersPrize;

    public PlayersPrize(Map<Player, Prize> playersPrize) {
        this.playersPrize = playersPrize;
    }

    public Prize searchPrize(Players searchedPlayer) {
        Player player = searchedPlayer.getPlayers().get(0);
        return playersPrize.get(player);
    }

    public Map<Player, Prize> getPlayersPrize() {
        return playersPrize;
    }
}
