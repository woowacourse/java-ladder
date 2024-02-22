package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final String NOT_POSITIVE_HEIGHT = "최대 사다리의 높이는 양수가 되어야 합니다";
    private final int maximumHeight;
    private final List<LadderRow> ladderRows;

    public Ladder(int maximumHeight) {
        validateHeightIsPositive(maximumHeight);
        this.ladderRows = new ArrayList<>();
        this.maximumHeight = maximumHeight;
    }

    private void validateHeightIsPositive(int maximumHeight) {
        if (maximumHeight < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_HEIGHT);
        }
    }

    public void build(int participantsSize) {
        for (int i = 0; i < maximumHeight; i++) {
            ladderRows.add(buildRow(participantsSize));
        }
    }

    private LadderRow buildRow(int participantsSize) {
        List<Boolean> lineStatus = new ArrayList<>();
        lineStatus.add(new Random().nextBoolean());
        for (int i = lineStatus.size(); i < participantsSize - 1; i++) {
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
