package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String LADDER_STEP = "-----";
    private static final String LADDER_SPACE = "     ";

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<String> steps = new ArrayList<>();

        for(boolean point : line.getPoints()) {
            steps.add((point) ? LADDER_STEP : LADDER_SPACE);
        }

        System.out.println("|" + String.join("|", steps) + "|");
    }
}
