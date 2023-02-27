package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static final int START_POINT_OF_LADDER = 0;
    private static final int MOVE_INDEX_VALUE = 1;
    private static final int DONT_CHANGE_IN_INDEX = 0;
    private static final String INVALID_INDEX_ERROR_MESSAGE = "해당 위치는 존재하지 않는 값입니다.";
    private static final int LINE_EDGE_HAVE_ONE_MORE_THAN_LINE = 1;
    private static final int TO_PREVIOUS_INDEX = 1;
    private static final int MAKE_DECREASE_VALUE = -1;

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

        int previousIndex = index - TO_PREVIOUS_INDEX;

        return lines.get(previousIndex).notExist();
    }

    public int getResultPosition(final int index) {
        validateIndexRange(index);
        return index + getAmountOfChange(index);
    }

    private void validateIndexRange(final int index) {
        if (index < 0 || index > lines.size()) {
            throw new IllegalArgumentException(INVALID_INDEX_ERROR_MESSAGE);
        }
    }

    private int getAmountOfChange(final int index) {
        return getDecreaseOf(index) + getIncreaseOf(index);
    }

    private int getDecreaseOf(final int index) {
        if (index == START_POINT_OF_LADDER) {
            return DONT_CHANGE_IN_INDEX;
        }
        if (lines.get(index - TO_PREVIOUS_INDEX).isExist()) {
            return MOVE_INDEX_VALUE * MAKE_DECREASE_VALUE;
        }
        return DONT_CHANGE_IN_INDEX;
    }

    private int getIncreaseOf(final int index) {
        if (index == lines.size()) {
            return DONT_CHANGE_IN_INDEX;
        }
        if (lines.get(index).isExist()) {
            return MOVE_INDEX_VALUE;
        }
        return DONT_CHANGE_IN_INDEX;
    }

    public int getSizeOfLineEdge() {
        return lines.size() + LINE_EDGE_HAVE_ONE_MORE_THAN_LINE;
    }

    public int size(){
        return this.lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

}
