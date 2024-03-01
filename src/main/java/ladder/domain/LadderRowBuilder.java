package ladder.domain;

import static ladder.domain.LadderDirection.LEFT;
import static ladder.domain.LadderDirection.NONE;
import static ladder.domain.LadderDirection.RIGHT;

import java.util.ArrayList;
import java.util.List;

public class LadderRowBuilder {

    private List<LadderDirection> ladderRow;
    private Width<LadderDirection> width;
    private LadderDirectionSelector ladderDirectionSelector;

    private LadderRowBuilder() {
    }

    public static LadderRowBuilder builder() {
        return new LadderRowBuilder();
    }

    public LadderRowBuilder width(Width<LadderDirection> width) {
        this.width = width;
        return this;
    }

    public LadderRowBuilder directionSelector(LadderDirectionSelector ladderDirectionSelector) {
        this.ladderDirectionSelector = ladderDirectionSelector;
        return this;
    }

    public LadderRow build() {
        ladderRow = new ArrayList<>(width.repeat(() -> LadderDirection.NONE));
        width.repeat(this::selectDirectionIfNotExistsAt);
        return LadderRow.from(ladderRow);
    }

    private void selectDirectionIfNotExistsAt(int index) {
        if (!isLastIndex(index) && ladderRow.get(index) == NONE) {
            selectDirectionAt(index);
        }
    }

    private boolean isLastIndex(int index) {
        return index == ladderRow.size() - 1;
    }

    private void selectDirectionAt(int index) {
        LadderDirection ladderDirection = ladderDirectionSelector.select();
        if (ladderDirection == RIGHT) {
            ladderRow.set(index, RIGHT);
            ladderRow.set(index + 1, LEFT);
        }
    }
}
