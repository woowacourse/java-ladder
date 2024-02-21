package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLevel {
    private final List<Direction> ladderLevel;

    public LadderLevel(int size, LineGenerator lineGenerator) {
        ladderLevel = new ArrayList<>();
        initialize(size);
        for (int index = 0; index < size - 1; index++) {
            setLines(lineGenerator, index);
        }
    }

    private void initialize(int size) {
        for (int i = 0; i < size; i++) {
            ladderLevel.add(NONE);
        }
    }

    private void setLines(LineGenerator lineGenerator, int index) {
        if (ladderLevel.get(index) == NONE) {
            Direction direction = lineGenerator.generate();
            setLineAt(index, direction);
        }
    }

    private void setLineAt(int index, Direction direction) {
        if (direction == RIGHT) {
            ladderLevel.set(index, RIGHT);
            ladderLevel.set(index + 1, LEFT);
        }
    }

    public Stream<Direction> stream() {
        return ladderLevel.stream();
    }
}
