package model;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(Height height, BooleanGenerator generator, int participantSize) {
        this.ladderRows = Stream.generate(() -> new LadderRow(generator, participantSize - 1))
                .limit(height.value()).toList();
    }

    Ladder(List<LadderRow> ladderRows) {
        this.ladderRows = ladderRows;
    }

    public int getHeight() {
        return ladderRows.size();
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }

    public int getLadderRowSize() {
        return ladderRows.get(0).size();
    }

    public Position findLinkedPosition(Position position) {
        return ladderRows.stream()
                .reduce(position,
                        (currentPosition, ladderRow) -> ladderRow.findLinkedPosition(currentPosition),
                        (a, b) -> b);
    }
}
