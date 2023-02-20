package ladder.domain.ladder;

import ladder.domain.valueGenerator.BooleanGenerator;

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
            List<Bar> bars = LineMaker.generate(count, booleanGenerator);
            lines.add(new Line(bars));
        }

        return new Ladder(lines);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int findLadderResult(int startIndex) {
        int currIndex = startIndex;
        for (Line line : ladder) {
            currIndex = currIndex + line.decideDirection(currIndex);
        }
        return currIndex;
    }

}
