package laddergame.domain.gameelements;

import laddergame.domain.Position;

public class Player {
    private static final Name RESERVED_NAME = new Name("all");

    final private Name name;
    private final Position position;

    public Player(Name name, Position position) {
        validateReservedName(name);
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        position.moveLeft();
    }

    public void moveRight() {
        position.moveRight();
    }

    private void validateReservedName(Name playerName) {
        if (playerName.equals(RESERVED_NAME)) {
            throw new IllegalArgumentException("예약어 " + RESERVED_NAME + "은 이름으로 지정할 수 없습니다.");
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

}
