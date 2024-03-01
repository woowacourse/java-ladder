package ladder.domain.ladder;

import java.util.List;
import java.util.function.Consumer;

import ladder.domain.ladder.direction.LadderDirection;

public record LadderRow(List<LadderDirection> ladderRow) {

    public static LadderRow from(final List<LadderDirection> ladderDirections) {
        return new LadderRow(ladderDirections);
    }

    public void forEach(final Consumer<LadderDirection> consumer) {
        ladderRow.forEach(consumer);
    }

    public LadderDirection getLadderDirection(final int index) {
        return ladderRow.get(index);
    }
}
