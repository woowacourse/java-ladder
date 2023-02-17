package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Floor {

    private static final int FIRST_LINE = 0;
    private static final int INDEX_DIFFERENCE = 1;

    private final List<Line> lines = new ArrayList<>();

    public Floor(int width) {

        for (int i = 0; i < width; i++) {
            lines.add(new Line());
        }
    }

    public void makeFloor(List<Boolean> lineValues) {

        for (int i = 0; i < lines.size(); i++) {
            makeLineAt(i, lineValues.get(i));
        }
    }

    private void makeLineAt(int index, boolean value) {

        if (isMakeAble(index)) {
            lines.get(index).make(value);
        }
    }

    private boolean isMakeAble(int index) {

        if (index == FIRST_LINE) {
            return true;
        }

        int previousIndex = index - INDEX_DIFFERENCE;

        return !lines.get(previousIndex).isExist();
    }

    public List<Boolean> getLines() {
        return lines.stream()
                .map(Line::isExist)
                .collect(Collectors.toList());
    }
}
