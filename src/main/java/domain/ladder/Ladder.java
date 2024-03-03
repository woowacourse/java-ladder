package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Players;
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

    // TODO: Ladder - Players 결합도 낮추기
    public void play(final Players players) {
        ladderRows.forEach(ladderRow -> ladderRow.playRow(players));
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }
}
