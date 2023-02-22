package laddergame.domain.prize;

import laddergame.domain.player.Player;

public class Result {

    private final Player player;
    private final Prize prize;

    public Result(final Player player, final Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public String getName() {
        return player.getName();
    }

    public String getPrize() {
        return prize.getPrize();
    }
}
