package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;

import java.util.Objects;

public class Player {

    private final PlayerName name;
    private Position position;

    public Player(final PlayerName name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Position traceThePath(final Ladder ladder) {
        position = ladder.findEndPositionOf(position);

        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public PlayerName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
