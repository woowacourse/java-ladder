package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private static final int FIRST_LINE = 0;
    private static final int INDEX_DIFFERENCE = 1;
    private final List<Line> lines = new ArrayList<>();


    public Floor(int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            lines.add(new Line());
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public void makeFloor(List<Integer> lineValues) {
        for (int i = 0; i < lines.size(); i++) {
            makeLineAt(i, lineValues.get(i));
        }
    }

    private void makeLineAt(int index, int value) {
        if (isMakeAble(index)) {
            lines.get(index).make(LineSource.of(value));
        }
    }

    private boolean isMakeAble(int index) {
        if (index == FIRST_LINE) {
            return true;
        }

        int previousIndex = index - INDEX_DIFFERENCE;

        return !lines.get(previousIndex).isExist();
    }
}
