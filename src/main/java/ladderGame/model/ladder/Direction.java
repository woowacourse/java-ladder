package ladderGame.model.ladder;

import java.util.function.Function;

public enum Direction {
    LEFT((pointIndex) -> pointIndex - 1),
    RIGHT((pointIndex) -> pointIndex + 1),
    STRAIGHT((pointIndex) -> (pointIndex));

    private Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int apply(int index) {
        return function.apply(index);
    }
}
