package domain;

import java.util.List;

public class LadderGame {
    public int playLine(int currentColumn, Line line) {
        List<Step> steps = line.getSteps();
        if (steps.get(currentColumn).isExist()) {
            return currentColumn + 1;
        }
        if (currentColumn > 0 && steps.get(currentColumn - 1).isExist()) {
            return currentColumn - 1;
        }
        return currentColumn;
    }
}
