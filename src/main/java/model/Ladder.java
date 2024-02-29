package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(Height height, LadderRowGenerator generator, int participantSize) {
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            LadderRow ladderRow = createLadderRow(generator, participantSize);
            rows.add(ladderRow);
        }
        this.ladder = rows;
    }

    Ladder(List<LadderRow> ladderRows) {
        this.ladder = ladderRows;
    }

    private LadderRow createLadderRow(LadderRowGenerator generator, int participantSize) {
        List<Boolean> rows = new ArrayList<>();
        rows.add(generator.generate(false));
        for (int i = 0; i < participantSize - 2; i++) {
            boolean generated = generator.generate(rows.get(i));
            rows.add(generated);
        }
        return new LadderRow(rows);
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
