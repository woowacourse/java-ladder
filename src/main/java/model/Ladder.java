package model;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(Height height, LadderRowGenerator generator, int participantSize) {
        //TODO: height.repeat()
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

    public Position moveAll(Position participantIndex) {
        Position currentPosition = ladderRows.get(0).move(participantIndex);
        for (int i = 1; i < ladderRows.size(); i++) {
            currentPosition = ladderRows.get(i).move(currentPosition);
        }
        return currentPosition;
    }
}
