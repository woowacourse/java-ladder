package ladder.domain.laddercomponent;

import ladder.domain.gamecomponent.Player;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONAL_LINE = "-----";
    private static final String LINE_SPACE = "     ";

    private Steps steps;

    public Line(Steps steps) {
        this.steps = steps;
    }

    public void getNextPositon(Player player) {
        player.move(steps);
    }

    @Override
    public String toString() {
        List<String> lineElements = new ArrayList<>();

        for (Step step : steps.getSteps()) {
            lineElements.add((step.exist()) ? HORIZONAL_LINE : LINE_SPACE);
        }

        return VERTICAL_LINE
                + String.join(VERTICAL_LINE, lineElements)
                + VERTICAL_LINE;
    }
}
