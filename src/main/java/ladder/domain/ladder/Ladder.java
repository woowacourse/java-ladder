package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.direction.DirectionGeneratorImpl;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;

public class Ladder {

    private static final int MAX_LADDER_HEIGHT = 50;

    private final List<Line> lines;

    public Ladder(int ladderHeight, int ladderWidth) {
        validateLinesSize(ladderHeight);
        this.lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());
        createLines(ladderHeight, ladderWidth, lineGenerator);
    }

    public List<Line> getLines() {
        return lines;
    }

    private void createLines(int ladderHeight, int ladderWidth, LineGenerator lineGenerator) {
        for (int i = 0; i < ladderHeight; i++) {
            this.lines.add(lineGenerator.generate(ladderWidth));
        }
    }

    private void validateLinesSize(int ladderHeight) {
        if (ladderHeight > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 최대 높이는 50이하만 가능합니다.");
        }
    }
}
