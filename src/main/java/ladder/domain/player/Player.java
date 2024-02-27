package ladder.domain.player;

import ladder.domain.Direction;
import ladder.domain.ladder.Rung;

import java.util.List;

public class Player {
    private final Name name;
    private final Position position;

    public Player(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Direction findMovableDirection(final List<Rung> rungs) {
        return position.findMovableDirection(rungs);
    }

    public void moveTo(final Direction direction) {
        position.add(direction.getValue());
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
