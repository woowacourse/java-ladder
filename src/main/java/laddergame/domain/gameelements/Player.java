package laddergame.domain.gameelements;

import laddergame.domain.Position;

public class Player {

    Name name;
    Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        position.moveLeft();
    }

    public void moveRight() {
        position.moveRight();
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

}
