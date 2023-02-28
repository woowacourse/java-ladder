package domain.player;

import domain.ladder.Direction;
import domain.ladder.Position;

import java.util.Objects;

public class Player {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "참가자 이름의 길이는 1이상 5이하만 가능합니다.";
    private static final String NAME_FORMAT_ERROR_MESSAGE = "참가자 이름에는 공백이 들어갈 수 없습니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String SPACE = " ";

    private final String name;
    private Position position;

    public Player(String name, int initialPosition) {
        validate(name);
        this.name = name;
        this.position = new Position(initialPosition);
    }

    public void move(Direction direction) {
        position = this.position.moveTo(direction);
    }

    private void validate(String name) {
        validateLength(name);
        validateSpace(name);
    }

    private void validateLength(String name) {
        if (isWrongNameSize(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isWrongNameSize(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    private void validateSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return new Position(position.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player name1 = (Player) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
