package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;

import java.util.Objects;

public class Player {

    private final PlayerName name;
    private Position position;

    public Player(PlayerName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position traceThePath(Ladder ladder) {
        position = ladder.findEndPositionOf(position);

        return position;
    }

    public PlayerName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
