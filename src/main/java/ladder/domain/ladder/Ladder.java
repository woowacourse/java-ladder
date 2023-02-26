package ladder.domain.ladder;

import ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> lines) {
        this.ladder = new ArrayList<>(lines);
    }

    public static Ladder create(int count, int height, BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int idx = 0; idx < height; idx++) {
            List<Bar> bars = generate(count, booleanGenerator);
            lines.add(new Line(bars));
        }

        return new Ladder(lines);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int findLadderResult(int startPosition) {
        int currPosition = startPosition;
        for (Line line : ladder) {
            currPosition = line.nextPosition(currPosition);
        }
        return currPosition;
    }


    public static List<Bar> generate(int playerCount, BooleanGenerator booleanGenerator) {
        int lineSize = playerCount - 1;
        List<Bar> line = new ArrayList<>();
        boolean beforeValue = false;
        for (int idx = 0; idx < lineSize; idx++) {
            Bar currentBar = createBar(beforeValue, booleanGenerator);
            line.add(currentBar);
            beforeValue = currentBar.getValue();
        }
        return line;
    }

    private static Bar createBar(boolean beforeValue, BooleanGenerator booleanGenerator) {
        if (beforeValue) {
            return Bar.UNMOVABLE_BAR;
        }

        return Bar.getBar(booleanGenerator.generateBoolean());
    }

}
