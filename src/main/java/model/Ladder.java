package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int height;
    private final List<LadderRow> ladderRows;

    public Ladder(int height, int participantsSize) {
        validateHeightIsPositive(height);
        this.ladderRows = makeEmptyLadder(height, participantsSize);
        this.height = height;
    }

    private List<LadderRow> makeEmptyLadder(int height, int participantsSize){
        List<LadderRow> emptyLadderRows = new ArrayList<>();
        for(int i = 0; i < height; i++){
            emptyLadderRows.add(new LadderRow(participantsSize));
        }
        return new ArrayList<>(emptyLadderRows);
    }

    private void validateHeightIsPositive(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("최대 사다리의 높이는 양수가 되어야 합니다");
        }
    }

    public void createRows() {
        for (int i = 0; i < height; i++) {
            createRow(ladderRows.get(i));
        }
    }

    private void createRow(LadderRow ladderRow) {
        while (ladderRow.currentWidthSize() < ladderRow.getMaxWidth()) {
            ladderRow.crossLine(new Random().nextBoolean());
        }
    }

    public int height() {
        return height;
    }

    public LadderRow getRow(int index) {
        return ladderRows.get(index);
    }
}
