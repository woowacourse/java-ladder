package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> ladderRows;

    public Ladder(final BooleanGenerator booleanGenerator, final Height height, final int playerSize) {
        ladderRows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = new LadderRow(booleanGenerator, playerSize);
            ladderRows.add(ladderRow);
        }
    }

    public void play(final Players players) {
        ladderRows.forEach(ladderRow -> ladderRow.playRow(players));
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }

    public int getHeight() {
        return ladderRows.size();
    }
}
