package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder(final BooleanGenerator booleanGenerator, final Height height, final int playerCount) {
        ladderRows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = new LadderRow(booleanGenerator, playerCount);
            ladderRows.add(ladderRow);
        }
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }
}
