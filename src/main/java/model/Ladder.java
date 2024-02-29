package model;

import java.util.ArrayList;
import java.util.List;
import utils.ThresholdChecker;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    public Ladder(ThresholdChecker thresholdChecker, String input, int personCount) {
        this.height = new Height(input);
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(thresholdChecker, personCount));
        }
    }

    public Direction findNextHorizontalPath(int horizontalPosition, int verticalPosition) {
       return lines.get(verticalPosition)
                .findDirection(horizontalPosition);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeightValue() {
        return height.getHeight();
    }

}
