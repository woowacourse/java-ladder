package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final Height height;
    private final List<LadderRow> ladderRows;

    public Ladder(int maximumHeight) {
        this.ladderRows = new ArrayList<>();
        this.height = new Height(maximumHeight);
    }

    public void build(int participantsSize) {
        for (int i = 0; i < height.value(); i++) {
            ladderRows.add(buildRow(participantsSize));
        }
    }

    private LadderRow buildRow(int participantsSize) {
        List<Boolean> isLines = new ArrayList<>();
        isLines.add(new Random().nextBoolean());
        for (int i = 1; i < participantsSize - 1; i++) {
            fillLineStatus(isLines, new Random().nextBoolean());
        }
        return new LadderRow(isLines);
    }

    private void fillLineStatus(List<Boolean> isLines, boolean isLine) {
        if (isLines.get(isLines.size() - 1).equals(true) && isLine) {
            isLines.add(false);
            return;
        }
        isLines.add(isLine);
    }

    public int getHeight() {
        return ladderRows.size();
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }
}
