package domain.ladder;

import domain.height.Height;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public static Ladder create(final Height height, final int playerSize, LadderRungGenerator ladderRungGenerator) {
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = LadderRow.create(playerSize - 1, ladderRungGenerator);
            rows.add(ladderRow);
        }
        return new Ladder(rows);
    }

    public int getHeight() {
        return rows.size();
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
