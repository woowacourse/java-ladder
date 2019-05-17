package ladder.domain;

public class Player {
    private final Position position;

    public Player(Position position) {
        this.position = position;
    }

    public Position move(Direction direction) {
        return new Position(position.getValue() + direction.move());
    }
}
