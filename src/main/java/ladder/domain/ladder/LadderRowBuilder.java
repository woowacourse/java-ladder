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
    private LadderDirectionSelector directionSelector;

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
        this.directionSelector = ladderDirectionSelector;
        return this;
    }

    public LadderRow build() {
        validateNonNull();
        ladderRow = new ArrayList<>(width.repeat(() -> LadderDirection.NONE));
        width.repeat(this::selectDirectionIfNotExistsAt);
        return new LadderRow(ladderRow);
    }

    private void validateNonNull() {
        if (width == null || directionSelector == null) {
            throw new IllegalStateException("사다리를 만들기 위해 필요한 정보를 모두 입력해주세요.");
        }
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
        LadderDirection ladderDirection = directionSelector.select();
        if (ladderDirection == RIGHT) {
            ladderRow.set(index, RIGHT);
            ladderRow.set(index + 1, LEFT);
        }
    }
}
