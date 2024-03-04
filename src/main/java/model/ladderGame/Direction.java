package model.laddergame;

import java.util.function.Consumer;
import model.players.Position;

public enum Direction {
    LEFT(position -> position.moveLeft()),
    RIGHT(position -> position.moveRight()),
    STRAIGHT(position -> {
    });

    private final Consumer<Position> expression;

    Direction(final Consumer<Position> expression) {
        this.expression = expression;
    }

    public void move(Position position) {
        expression.accept(position);
    }
}
