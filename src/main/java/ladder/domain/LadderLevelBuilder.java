package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLevelBuilder {

    private final List<Direction> ladderLevel;

    private int size;
    private LadderDirectionSelector ladderDirectionSelector;

    private LadderLevelBuilder() {
        this.ladderLevel = new ArrayList<>();
    }

    public static LadderLevelBuilder builder() {
        return new LadderLevelBuilder();
    }

    public LadderLevelBuilder size(int size) {
        this.size = size;
        return this;
    }

    public LadderLevelBuilder directionSelector(LadderDirectionSelector ladderDirectionSelector) {
        this.ladderDirectionSelector = ladderDirectionSelector;
        return this;
    }

    public LadderLevel build() {
        IntStream.range(0, size).forEach((__) -> ladderLevel.add(Direction.NONE));
        IntStream.range(0, size - 1).forEach(this::selectDirectionIfNotExistsAt);
        return new LadderLevel(ladderLevel);
    }

    private void selectDirectionIfNotExistsAt(int index) {
        if (ladderLevel.get(index) == NONE) {
            selectDirectionAt(index);
        }
    }

    private void selectDirectionAt(int index) {
        Direction direction = ladderDirectionSelector.select();
        if (direction == RIGHT) {
            ladderLevel.set(index, RIGHT);
            ladderLevel.set(index + 1, LEFT);
        }
    }
}
