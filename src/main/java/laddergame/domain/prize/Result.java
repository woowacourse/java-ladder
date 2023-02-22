package laddergame.domain.prize;

import laddergame.domain.player.Names;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.List;

public class Result {

    private final Players players;
    private final Prizes prizes;

    public Result(final Players players, final Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public Names findPlayerNames() {
        return players.findPlayerNames();
    }

    public List<Prize> getPrizes() {
        return prizes.getPrizes();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }
}
