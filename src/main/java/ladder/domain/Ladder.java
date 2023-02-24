package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String POSITION_SIZE_ERROR_MESSAGE = "사다리 시작점은 0이상 %d이하이어야합니다.";
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public List<Integer> getAllEndPosition() {
        List<Integer> endPositions = new ArrayList<>();
        for (int startPosition = 0; startPosition <= getLadderWidth(); startPosition++) {
            endPositions.add(getEndPosition(startPosition));
        }
        return endPositions;
    }

    public int getEndPosition(int startPosition) {
        validatePosition(startPosition);
        int curPosition = startPosition;
        for (int height = 0; height < ladder.size(); height++) {
            curPosition = getNextPosition(curPosition, height);
        }
        return curPosition;
    }

    private int getNextPosition(int curPosition, int height) {
        int nextPosition = curPosition;
        Row row = ladder.get(height);
        if (isMovableToLeft(curPosition, row)) {
            nextPosition = curPosition - 1;
        }
        if (isMovableToRight(curPosition, row)) {
            nextPosition = curPosition + 1;
        }
        return nextPosition;
    }

    private boolean isMovableToLeft(int curPosition, Row row) {
        int leftWidth = getLeftWidth(curPosition);
        return row.isStepExist(leftWidth);
    }

    private boolean isMovableToRight(int curPosition, Row row) {
        int rightWidth = getRightWidth(curPosition);
        return row.isStepExist(rightWidth);
    }

    private int getLeftWidth(int position) {
        return position - 1;
    }

    private int getRightWidth(int position) {
        return position;
    }

    private void validatePosition(int position) {
        if (position < 0 || position > getLadderWidth()) {
            throw new IllegalArgumentException(String.format(POSITION_SIZE_ERROR_MESSAGE, getLadderWidth()));
        }
    }

    private int getLadderWidth() {
        return ladder.get(0).size();
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
