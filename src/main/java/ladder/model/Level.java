package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<Integer> verticalLines;

    public Level(int width, Possible possibility) {
        verticalLines = Collections.unmodifiableList(drawOrPass(0, width, possibility, new ArrayList<>()));
    }

    private List<Integer> drawOrPass(int target, int left, Possible possibility, List<Integer> verticalLines) {
        if (possibility.isPossible() && left > 0) {
            verticalLines.add(target);
            return drawOrPass(target + 2, left - 2, possibility, verticalLines);
        }
        if (left > 0) {
            return drawOrPass(target + 1, left - 1, possibility, verticalLines);
        }
        return verticalLines;
    }

    public List<Integer> getVerticalLines() {
        return verticalLines;
    }
}