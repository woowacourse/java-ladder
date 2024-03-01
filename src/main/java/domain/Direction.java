package domain;

import java.util.function.UnaryOperator;

public enum Direction {
    LEFT(Index::decrease),
    RIGHT(Index::increase),
    STRAIGHT(UnaryOperator.identity());

    private final UnaryOperator<Index> converter;

    Direction(UnaryOperator<Index> converter) {
        this.converter = converter;
    }

    public UnaryOperator<Index> getConverter() {
        return converter;
    }
}
