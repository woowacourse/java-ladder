package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import ladder.domain.attribute.Height;
import ladder.domain.attribute.Width;
import ladder.domain.ladder.direction.DefaultLadderDirectionSelector;
import ladder.domain.ladder.direction.LadderDirection;
import ladder.domain.ladder.direction.LadderDirectionSelector;

public class Ladder {

    private final List<LadderRow> ladder;

    private Ladder(final Height height, final Width width, final LadderDirectionSelector directionSelector) {
        ladder = new ArrayList<>();
        IntStream.range(0, height.value())
                .forEach(__ -> ladder.add(LadderRow.of(width, directionSelector)));
    }

    public static Ladder of(final Height height, final Width width) {
        return Ladder.of(height, width, new DefaultLadderDirectionSelector());
    }

    public static Ladder of(final Height height, final Width width, final LadderDirectionSelector directionSelector) {
        return new Ladder(
                Objects.requireNonNull(height, "사다리의 높이가 입력되지 않았습니다."),
                Objects.requireNonNull(width, "사다리의 너비가 입력되지 않았습니다."),
                Objects.requireNonNull(directionSelector, "사다리 방향 선택자가 입력되지 않았습니다.")
        );
    }

    public LadderPosition climbDownFrom(final LadderPosition ladderPosition) {
        if (isLastRow(ladderPosition)) {
            return ladderPosition;
        }
        LadderDirection direction = getLadderDirectionAt(ladderPosition);
        LadderPosition nextLadderPosition = ladderPosition.next(direction);
        return climbDownFrom(nextLadderPosition);
    }

    private boolean isLastRow(final LadderPosition ladderPosition) {
        return ladderPosition.row() == ladder.size();
    }

    private LadderDirection getLadderDirectionAt(final LadderPosition ladderPosition) {
        LadderRow ladderRow = ladder.get(ladderPosition.row());
        return ladderRow.ladderDirectionAt(ladderPosition.column());
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladder);
    }
}
