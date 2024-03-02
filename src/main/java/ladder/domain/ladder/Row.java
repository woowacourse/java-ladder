package ladder.domain.ladder;

import ladder.domain.ladder.generator.GenerateDirectionStrategy;
import ladder.domain.ladder.generator.RandomStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {

    private static final int MIN_SIZE = 2;
    private static final GenerateDirectionStrategy randomGenerator = new RandomStrategy();
    private final List<Direction> row;


    public Row(final int size) {
        validationSize(size);

        this.row = new ArrayList<>();

        IntStream.range(0, size)
                .forEach(i -> row.add(getDirection(size)));
    }

    public int goDown(final int index) {
        return index + row.get(index).getDirection();
    }

    public List<Direction> getRow() {
        return row;
    }

    public int size() {
        return row.size();
    }

    private void validationSize(final int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("사람은 2명 이상이어야 한다.");
        }
    }

    private Direction getDirection(final int size) {
        if (isPreviousDirectionRight()) {
            return Direction.LEFT;
        }
        if (randomGenerator.creatable() && size() < size - 1) {
            return Direction.RIGHT;
        }
        return Direction.INPLACE;
    }

    private boolean isPreviousDirectionRight() {
        if (row.isEmpty()) {
            return false;
        }

        return row.get(size() - 1) == Direction.RIGHT;
    }
}
