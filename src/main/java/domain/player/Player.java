package domain.player;

import domain.ladder.Line;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSameName(String otherName) {
        return name.isSame(otherName);
    }

    public void move(Line line) {
        if (position.isLeftSidePassable(line)) {
            position.moveLeft();
            return;
        }

        if (position.isRightSidePassable(line)) {
            position.moveRight();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
