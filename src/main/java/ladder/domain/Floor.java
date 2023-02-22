package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static final int START_POINT_OF_LADDER = 0;
    private static final int VALUE_TO_LINE = 1;
    private static final int MOVE_INDEX_VALUE = 1;
    private static final int DONT_CHANGE_IN_INDEX = 0;
    private static final String INVALID_INDEX_ERROR_MESSAGE = "해당 위치는 존재하지 않는 값입니다.";
    private static final int FLOORT_SIZE_HAVE_ONE_MORE_THAN_LINES = 1;
    private final List<Line> lines = new ArrayList<>();

    public Floor(int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            lines.add(new Line());
        }
    }

    public void makeFloor(List<LineSource> lineValues) {
        for (int i = 0; i < lines.size(); i++) {
            makeLineAt(i, lineValues.get(i));
        }
    }

    private void makeLineAt(int index, LineSource value) {
        if (isMakeAble(index)) {
            lines.get(index).make(value);
        }
    }

    private boolean isMakeAble(int index) {
        if (index == START_POINT_OF_LADDER) {
            return true;
        }

        int previousIndex = index - VALUE_TO_LINE;

        return lines.get(previousIndex).notExist();
    }

    public int getResultPosition(final int index) {
        validateIndex(index);
        if (endOfLadder(index)) {
            return index + checkEndLadder(index);
        }
        return index + checkLine(index);
    }

    private void validateIndex(final int index) {
        if (index < 0 || index > lines.size()) {
            throw new IllegalArgumentException(INVALID_INDEX_ERROR_MESSAGE);
        }
    }

    private int checkLine(final int index) {
        return getIndexDecrementOfLeft(index) + getIndexIncrementOfRight(index);
    }

    private int checkEndLadder(final int index) {
        if (index == START_POINT_OF_LADDER) {
            return getIndexIncrementOfRight(index);
        }
        return getIndexDecrementOfLeft(index);
    }


    private int getIndexIncrementOfRight(final int index) {
        if (lines.get(index).isExist()) {
            return MOVE_INDEX_VALUE;
        }
        return DONT_CHANGE_IN_INDEX;
    }

    private int getIndexDecrementOfLeft(final int index) {
        if (lines.get(index - VALUE_TO_LINE).isExist()) {
            return MOVE_INDEX_VALUE * (-1);
        }
        return DONT_CHANGE_IN_INDEX;
    }

    private boolean endOfLadder(final int index) {
        return index == START_POINT_OF_LADDER || index == lines.size();
    }

    public int getSize() {
        return lines.size() + FLOORT_SIZE_HAVE_ONE_MORE_THAN_LINES;
    }

    public List<Line> getLines() {
        return lines;
    }

}
