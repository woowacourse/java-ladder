package domain;

import java.util.ArrayList;
import java.util.List;

import utils.LadderRowGenerator;

public class Ladder {
    private final List<LadderRow> ladderRows = new ArrayList<>();
    private final LadderRowGenerator ladderRowGenerator;

    public Ladder(LadderRowGenerator ladderRowGenerator) {
        this.ladderRowGenerator = ladderRowGenerator;
    }

    public void create(int ladderHeight, int userCount) {
        for (int i = 0; i < ladderHeight; i++) {
            LadderRow ladderRow = ladderRowGenerator.generate(userCount);
            ladderRows.add(ladderRow);
        }
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }

    public int calculateEndIndex(int index) {
        for (LadderRow ladderRow : ladderRows) {
            int nextSummand = ladderRow.calculateNextSummand(index);
            index += nextSummand;
        }
        return index;
    }
}
