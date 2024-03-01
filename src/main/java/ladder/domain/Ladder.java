package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(List<LadderRow> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Players players, Height<LadderRow> height,
                            LadderDirectionSelector ladderDirectionSelector) {
        List<LadderRow> ladder = height.repeat(() -> LadderRowBuilder.builder()
                .size(players.count())
                .directionSelector(ladderDirectionSelector)
                .build());
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

    public List<LadderRow> getLadderLevels() {
        return Collections.unmodifiableList(ladder);
    }
}
