package domain.model;

import domain.vo.Name;
import domain.vo.Position;

public class Player {
    private final Name name;
    private Position position;

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        this.position = new Position(this.position.get() - 1);
    }

    public void moveRight() {
        this.position = new Position(this.position.get() + 1);
    }

    public String getName() {
        return this.name.get();
    }

    public int getPosition() {
        return this.position.get();
    }
}
