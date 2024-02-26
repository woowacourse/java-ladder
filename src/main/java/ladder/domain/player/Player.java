package ladder.domain.player;

import ladder.domain.Direction;

public class Player {
    private final Name name;
    private final Position position;

    public Player(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final Direction direction) {
        position.add(direction.getValue());
    }

    public String getName() {
        return name.getValue();
    }
}
