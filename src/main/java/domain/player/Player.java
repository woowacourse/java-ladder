package domain.player;

import domain.ladder.DirectionalRung;

public class Player {
    private final Name name;
    private int position;

    public Player(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(DirectionalRung direction) {
        position += direction.getDirection();
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
