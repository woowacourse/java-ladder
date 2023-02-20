package ladder.domain;

import java.util.Objects;

public class PlayerResult {
    private final Player player;
    private final Result result;

    public PlayerResult(Player player, Result result) {
        this.player = player;
        this.result = result;
    }

    public boolean isPlayerMatch(Player player) {
        return Objects.equals(this.player, player);
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getResult() {
        return result.getResult();
    }
}
