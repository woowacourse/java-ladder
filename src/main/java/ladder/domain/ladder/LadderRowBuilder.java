package ladder.domain.ladder;

import static ladder.domain.ladder.direction.LadderDirection.LEFT;
import static ladder.domain.ladder.direction.LadderDirection.NONE;
import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.attribute.Width;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.ladder.direction.LadderDirectionSelector;

public class LadderRowBuilder {

    private List<LadderDirection> ladderRow;
    private Width width;
    private LadderDirectionSelector ladderDirectionSelector;

    private LadderRowBuilder() {
    }

    public static LadderRowBuilder builder() {
        return new LadderRowBuilder();
    }

    public LadderRowBuilder width(final Width width) {
        this.width = width;
        return this;
    }

    public LadderRowBuilder directionSelector(final LadderDirectionSelector ladderDirectionSelector) {
        this.ladderDirectionSelector = ladderDirectionSelector;
        return this;
    }

    public LadderRow build() {
        ladderRow = new ArrayList<>(width.repeat(() -> LadderDirection.NONE));
        width.repeat(this::selectDirectionIfNotExistsAt);
        return new LadderRow(ladderRow);
    }

    private void selectDirectionIfNotExistsAt(final int index) {
        if (!isLastIndex(index) && ladderRow.get(index) == NONE) {
            selectDirectionAt(index);
        }
    }

    private boolean isLastIndex(final int index) {
        return index == ladderRow.size() - 1;
    }

    private void selectDirectionAt(final int index) {
        LadderDirection ladderDirection = ladderDirectionSelector.select();
        if (ladderDirection == RIGHT) {
            ladderRow.set(index, RIGHT);
            ladderRow.set(index + 1, LEFT);
        }
    }
}
