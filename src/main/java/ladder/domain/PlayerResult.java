package ladder.domain;

import java.util.Objects;

public class PlayerResult {
    private final Player player;
    private final Prize prize;

    public PlayerResult(Player player, Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public boolean isPlayerMatch(Player player) {
        return Objects.equals(this.player, player);
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPrize() {
        return prize.getPrize();
    }
}
