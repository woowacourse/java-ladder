package domain.ladder;

import domain.booleanGenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public static Ladder create(final BooleanGenerator booleanGenerator, final Height height, final int playerSize) {
        final List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = LadderRow.create(booleanGenerator, getColumnSize(playerSize));
            rows.add(ladderRow);
        }
        return new Ladder(rows);
    }

    private static int getColumnSize(final int playerSize) {
        return playerSize - 1;
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getHeight() {
        return rows.size();
    }
}
