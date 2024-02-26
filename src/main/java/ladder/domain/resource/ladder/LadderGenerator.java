package ladder.domain.resource.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.DirectionGenerator;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;

public class LadderGenerator {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 50;
    private static final int MIN_LADDER_WIDTH = 2;
    private static final int MAX_LADDER_WIDTH = 10;

    private final LineGenerator lineGenerator;

    public LadderGenerator(DirectionGenerator directionGenerator) {
        this.lineGenerator = new LineGenerator(directionGenerator);
    }

    public Ladder generate(int height, int width) {
        validateHeight(height);
        validateWidth(width);

        List<Line> lines = generateLines(height, width);
        return new Ladder(lines);
    }

    private List<Line> generateLines(int count, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lines.add(lineGenerator.generate(width));
        }

        return lines;
    }

    private void validateHeight(int height) {
        if (height < MIN_LADDER_HEIGHT || height > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1~50만 가능합니다.");
        }
    }

    private void validateWidth(int width) {
        if (width < MIN_LADDER_WIDTH || width > MAX_LADDER_WIDTH) {
            throw new IllegalArgumentException("[ERROR] 사다리의 너비는 2~10만 가능합니다.");
        }
    }
}
