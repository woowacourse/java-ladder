package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder() {
        this.ladderRows = new ArrayList<>();
    }

    public void build(Function<Integer, List<Boolean>> generator, Height height, Participants participants) {
        for (int i = 0; i < height.getValue(); i++) {
            ladderRows.add(new LadderRow(
                    generator.apply(participants.size()-1))
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
