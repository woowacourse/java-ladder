package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderRowBuilder {

    private final List<LadderDirection> ladderRow;

    private int size;
    private LadderDirectionSelector ladderDirectionSelector;

    private LadderRowBuilder() {
        this.ladderRow = new ArrayList<>();
    }

    public static LadderRowBuilder builder() {
        return new LadderRowBuilder();
    }

    public LadderRowBuilder size(int size) {
        this.size = size;
        return this;
    }

    public LadderRowBuilder directionSelector(LadderDirectionSelector ladderDirectionSelector) {
        this.ladderDirectionSelector = ladderDirectionSelector;
        return this;
    }

    public LadderRow build() {
        IntStream.range(0, size).forEach(__ -> ladderRow.add(LadderDirection.NONE));
        IntStream.range(0, size - 1).forEach(this::selectDirectionIfNotExistsAt);
        return new LadderRow(ladderRow);
    }

    private void selectDirectionIfNotExistsAt(int index) {
        if (ladderRow.get(index) == NONE) {
            selectDirectionAt(index);
        }
    }

    private void selectDirectionAt(int index) {
        LadderDirection ladderDirection = ladderDirectionSelector.select();
        if (ladderDirection == RIGHT) {
            ladderRow.set(index, RIGHT);
            ladderRow.set(index + 1, LEFT);
        }
    }
}
