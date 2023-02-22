package laddergame.domain;

import laddergame.domain.player.Names;
import laddergame.domain.player.Player;

import java.util.List;

public class Result {

    private final Players players;
    private final Prizes prizes;

    public Result(final Players players, final Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public List<Prize> getPrizes() {
        return prizes.getPrizes();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }

    public Names findPlayerNames() {
        return players.findPlayerNames();
    }
}
