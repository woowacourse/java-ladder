package ladder.domain.ladder;

import static ladder.domain.ladder.direction.LadderDirection.LEFT;
import static ladder.domain.ladder.direction.LadderDirection.NONE;
import static ladder.domain.ladder.direction.LadderDirection.RIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import ladder.domain.attribute.Width;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.ladder.direction.LadderDirectionSelector;

public class LadderRow {

    private final List<LadderDirection> ladderRow;

    private LadderRow(final Width width, final LadderDirectionSelector directionSelector) {
        ladderRow = new ArrayList<>();
        IntStream.range(0, width.value())
                .forEach(__ -> ladderRow.add(NONE));
        IntStream.range(0, width.value())
                .forEach(index -> selectDirectionsOf(directionSelector, index));
    }

    public static LadderRow of(final Width width, final LadderDirectionSelector directionSelector) {
        return new LadderRow(
                Objects.requireNonNull(width, "사다리의 너비가 입력되지 않았습니다."),
                Objects.requireNonNull(directionSelector, "사다리 방향 선택자가 입력되지 않았습니다.")
        );
    }

    private void selectDirectionsOf(final LadderDirectionSelector directionSelector, final int index) {
        if (!isLastIndex(index) && ladderRow.get(index) == NONE) {
            selectDirectionAt(directionSelector, index);
        }
    }

    private boolean isLastIndex(final int index) {
        return index == ladderRow.size() - 1;
    }

    private void selectDirectionAt(final LadderDirectionSelector directionSelector, final int index) {
        LadderDirection ladderDirection = directionSelector.select();
        if (ladderDirection == RIGHT) {
            ladderRow.set(index, RIGHT);
            ladderRow.set(index + 1, LEFT);
        }
    }

    public void forEach(final Consumer<LadderDirection> consumer) {
        ladderRow.forEach(consumer);
    }

    public LadderDirection ladderDirectionAt(final int index) {
        return ladderRow.get(index);
    }
}
