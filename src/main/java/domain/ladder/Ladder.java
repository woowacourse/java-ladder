package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;

    public Ladder(final BooleanGenerator booleanGenerator, final Height height, final int playerSize) {
        rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = new LadderRow(booleanGenerator, playerSize);
            rows.add(ladderRow);
        }
    }

    public void play(final Players players) {
        rows.forEach(row -> row.playRow(players));
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getHeight() {
        return rows.size();
    }
}
