package laddergame.domain.prize;

import laddergame.domain.player.Name;
import laddergame.domain.player.Player;

import java.util.Objects;

public class Result {

    private final Player player;
    private final Prize prize;

    public Result(final Player player, final Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public boolean equalsName(final Name name) {
        return player.equalsName(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result = (Result) o;
        return Objects.equals(player, result.player) && Objects.equals(prize, result.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, prize);
    }

    public String getName() {
        return player.getName();
    }

    public String getPrize() {
        return prize.getPrize();
    }
}
