package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int playerCount, int height) {
        StepPointGenerator stepPointGenerator = new RandomStepPointGenerator();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(stepPointGenerator, playerCount - 1));
        }
    }

    public List<Line> toUnModifiableLines() {
        return Collections.unmodifiableList(lines);
    }
}
