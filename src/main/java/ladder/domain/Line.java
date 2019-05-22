package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONAL_LINE = "-----";
    private static final String LINE_SPACE = "     ";

    private List<Step> steps;

    public Line(List<Step> steps) {
        this.steps = steps;
    }

    public int getNextPositon(Player player) {
        return player.tryMove(steps);
    }

    @Override
    public String toString() {
        List<String> lineElements = new ArrayList<>();

        for (Step step : steps) {
            lineElements.add((step.exist()) ? HORIZONAL_LINE : LINE_SPACE);
        }

        return VERTICAL_LINE
                + String.join(VERTICAL_LINE, lineElements)
                + VERTICAL_LINE;
    }
}
