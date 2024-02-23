package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder() {
        this.ladderRows = new ArrayList<>();
    }

    public void build(Height height, Participants participants) {
        for (int i = 0; i < height.getValue(); i++) {
            ladderRows.add(createOneRow(participants));
        }
    }

    private LadderRow createOneRow(Participants participants) {
        List<Boolean> row = new ArrayList<>();
        for (int i = 1; i < participants.size() - 1; i++) {
            row.add(new Random().nextBoolean());
        }
        return new LadderRow(row);
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }

    public List<LadderRow> getLadderRows() {
        return new ArrayList<>(ladderRows);
    }
}
