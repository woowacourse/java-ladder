package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLevel> ladder;

    public Ladder(List<LadderLevel> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Players players, Height height, LadderDirectionSelector ladderDirectionSelector) {
        List<LadderLevel> ladder = new ArrayList<>();
        IntStream.range(0, height.value()).forEach(
                __ -> ladder.add(LadderLevelBuilder.builder()
                        .size(players.count())
                        .directionSelector(ladderDirectionSelector)
                        .build())
        );
        return new Ladder(ladder);
    }

    public LadderPosition climbFrom(LadderPosition ladderPosition) {
        if (ladderPosition.row() == ladder.size()) {
            return ladderPosition;
        }
        LadderDirection direction = getLadderDirection(ladderPosition.row(), ladderPosition.column());
        LadderPosition nextLadderPosition = new LadderPosition(
                ladderPosition.row() + 1,
                ladderPosition.column() + direction.getValue());
        return climbFrom(nextLadderPosition);
    }

    private LadderDirection getLadderDirection(int row, int column) {
        return ladder.get(row).getLadderDirection(column);
    }

    public List<LadderLevel> getLadderLevels() {
        return Collections.unmodifiableList(ladder);
    }
}
