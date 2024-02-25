package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladder;

    public Ladder(Height height, BooleansGenerator generator) {
        List<LadderRow> ladderRows = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            List<Boolean> rows = generator.generateNotConsecutiveTrue();
            ladderRows.add(new LadderRow(rows));
        }
        this.ladder = ladderRows;
    }

    public int getHeight() {
        return ladder.size();
    }

    public LadderRow getRow(int index) {
        return ladder.get(index);
    }
}
