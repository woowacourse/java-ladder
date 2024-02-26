package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder(Function<Integer, List<Boolean>> generator, Height height, Participants participants) {
        this.ladderRows = new ArrayList<>();
        this.build(generator, height, participants);
    }

    private void build(Function<Integer, List<Boolean>> generator, Height height, Participants participants) {
        for (int i = 0; i < height.getValue(); i++) {
            ladderRows.add(new LadderRow(
                    generator.apply(participants.size() - 1))
            );
        }
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }

    public List<LadderRow> getLadderRows() {
        return new ArrayList<>(ladderRows);
    }
}
