package domain.ladder;

import domain.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public static Ladder create(final int height, final int playerSize, BooleanGenerator booleanGenerator) {
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            final LadderRow ladderRow = LadderRow.create(playerSize, booleanGenerator);
            rows.add(ladderRow);
        }
        return new Ladder(rows);
    }

    public int getHeight() {
        return rows.size();
    }
}
