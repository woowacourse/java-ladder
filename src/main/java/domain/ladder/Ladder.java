package domain.ladder;

import domain.BooleanGenerator;
import domain.Height;
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
        for (int i = 0; i < height.getValue(); i++) { // TODO 매직넘버 변수 설정
            final LadderRow ladderRow = LadderRow.create(booleanGenerator, playerSize - 1);
            rows.add(ladderRow);
        }
        return new Ladder(rows);
    }
    
    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public int getHeight() {
        return rows.size();
    }
}
