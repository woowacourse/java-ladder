package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.direction.RandomDirectionGenerator;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;
import ladder.util.BaseException;

public class Ladder {

    private static final int MAX_LADDER_HEIGHT = 50;

    private final List<Line> lines;

    public Ladder(int ladderHeight, int ladderWidth) {
        validateLinesSize(ladderHeight);
        LineGenerator lineGenerator = new LineGenerator(new RandomDirectionGenerator());
        this.lines = createLines(ladderHeight, ladderWidth, lineGenerator);
    }

    private List<Line> createLines(int ladderHeight, int ladderWidth, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(lineGenerator.generate(ladderWidth));
        }
        return lines;
    }

    private void validateLinesSize(int ladderHeight) {
        if (ladderHeight > MAX_LADDER_HEIGHT) {
            throw new BaseException("사다리의 최대 높이는 50이하만 가능합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
