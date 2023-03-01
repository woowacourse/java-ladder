package laddergame.domain.game.player;

import laddergame.domain.PersonalName;

public class Player {
    private final PersonalName personalName;
    private Position position;

    public Player(PersonalName personalName, int value) {
        this.personalName = personalName;
        this.position = new Position(value);
    }

    public void moveRight() {
        position = new Position(position.getValue() + 1);
    }

    public void moveLeft() {
        if (position.getValue() == 0) {
            throw new IllegalArgumentException("더이상 왼쪽으로 움직일 수 없습니다.");
        }
        position = new Position(position.getValue() - 1);
    }

    public PersonalName getPersonalName() {
        return personalName;
    }

    public Position getPosition() {
        return position;
    }
}
