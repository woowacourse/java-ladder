package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.LadderRowGenerator;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(final int userCount, final int height, final LadderRowGenerator ladderRowGenerator) {
        ladderRows = new ArrayList<>();
        create(userCount, height, ladderRowGenerator);
    }

    private void create(final int userCount, final int height, final LadderRowGenerator ladderRowGenerator) {
        for (int i = 0; i < height; i++) {
            LadderRow line = ladderRowGenerator.generate(userCount);
            ladderRows.add(line);
        }
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }
}
