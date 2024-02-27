package domain;

import java.util.Collections;
import java.util.Map;

public class PlayersPrize {
    private final Map<Player, Prize> playersPrize;

    public PlayersPrize(Map<Player, Prize> playersPrize) {
        this.playersPrize = playersPrize;
    }

    public Prize searchPrize(Players searchedPlayer) {  // TODO: 파라미터 타입과 파라미터명의 불일치
        Player player = searchedPlayer.getPlayers().get(0);
        return playersPrize.get(player);
    }

    public Map<Player, Prize> getPlayersPrize() {
        return Collections.unmodifiableMap(playersPrize);
    }
}
