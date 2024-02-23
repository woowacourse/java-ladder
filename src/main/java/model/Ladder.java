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
        List<Boolean> lineStatus = new ArrayList<>();
        lineStatus.add(new Random().nextBoolean());
        for (int i = 1; i < participantsSize - 1; i++) {
            fillLineStatus(lineStatus, new Random().nextBoolean());
        }
        return new LadderRow(lineStatus);
    }

    private void fillLineStatus(List<Boolean> lineStatus, boolean linesOrNoLine) {
        if (lineStatus.get(lineStatus.size() - 1).equals(true) && linesOrNoLine) {
            lineStatus.add(false);
            return;
        }
        lineStatus.add(linesOrNoLine);
    }

    public int height() {
        return ladderRows.size();
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }
}
