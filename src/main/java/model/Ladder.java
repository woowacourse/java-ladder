package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(Height height, LadderRowGenerator generator, int participantSize) {
        //TODO: height.repeat()
        this.ladder = IntStream.range(0, height.value())
                .mapToObj(index -> new LadderRow(generator, participantSize - 2))
                .toList();
    }

    Ladder(List<LadderRow> ladderRows) {
        this.ladder = ladderRows;
    }

    public int getHeight() {
        return ladder.size();
    }

    public LadderRow getRow(int index) {
        return ladder.get(index);
    }

    public int getLadderRowSize() {
        return ladder.get(0).size();
    }

    public Position moveAll(Position participantIndex) {
        Position currentPosition = ladder.get(0).move(participantIndex);
        for (int i = 1; i < ladder.size(); i++) {
            currentPosition = ladder.get(i).move(currentPosition);
        }
        return currentPosition;
    }
}
