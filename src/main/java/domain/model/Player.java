package domain.model;

import domain.vo.Name;
import domain.wrapper.Position;

public class Player {

    private final Name name;
    private final Position position;

    private Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(Name name, Position position) {
        return new Player(name, position);
    }

    public void move(Ladder ladder) {
        if (ladder.hasLeftAt(position)) {
            moveLeft();
            return;
        }
        if (ladder.hasRightAt(position)) {
            moveRight();
        }
    }

    private void moveLeft() {
        position.subX();
        position.addY();
    }

    private void moveRight() {
        position.addX();
        position.addY();
    }

    public int getXPosition() {
        return position.getX();
    }

    public int getYPosition() {
        return position.getY();
    }

    public Name getName() {
        return name;
    }
}
