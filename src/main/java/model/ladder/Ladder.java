package model.ladder;

import model.participant.Participants;
import model.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder(BiFunction<Integer, Integer, List<List<Boolean>>> generator, Height height, Participants participants) {
        this.ladderRows = new ArrayList<>();
        this.build(generator, height, participants);
    }

    private void build(BiFunction<Integer, Integer, List<List<Boolean>>> generator, Height height, Participants participants) {
        Integer rowCount = participants.size() - 1;
        Integer columnCount = height.getValue();
        List<List<Boolean>> ladder = generator.apply(rowCount, columnCount);
        for (int i = 0; i < height.getValue(); i++) {
            ladderRows.add(new LadderRow(ladder.get(i)));
        }
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }

    public List<LadderRow> getLadderRows() {
        return new ArrayList<>(ladderRows);
    }

    public int getHeight() {
        return ladderRows.size();
    }

    public Position getFinishPositionBy(Position startPosition) {
        Position endPosition = startPosition;
        for (LadderRow ladderRow : ladderRows) {
            endPosition = ladderRow.climb(endPosition);
        }
        return endPosition;
    }
}
