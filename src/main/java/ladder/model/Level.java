package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Integer> verticalLines = new ArrayList<>();

    public Level(int width, Possible possibility) {
        drawOrPass(0, width, possibility);
    }

    private void drawOrPass(int target, int left, Possible possibility) {
        if (possibility.isPossible() && left > 0) {
            verticalLines.add(target);
            drawOrPass(target + 2, left - 2, possibility);
            return;
        }
        if (left > 0) {
            drawOrPass(target + 1, left - 1, possibility);
        }
    }

    public List<Integer> getVerticalLines() {
        return verticalLines;
    }
}