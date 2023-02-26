package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private static final String INVALID_HEIGHT_MESSAGE = "사다리의 높이는 참가자 수 이상이어야 합니다.";

    private final BooleanGenerator booleanGenerator;

    public LadderGenerator(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Ladder generateLadder(final int height, final int personCount) {
        validate(height, personCount);
        LineGenerator lineGenerator = new LineGenerator(booleanGenerator);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generateLine(personCount);
            lines.add(line);
        }

        return new Ladder(lines);
    }

    private void validate(final int height, final int personCount) {
        validateHeight(height, personCount);
    }

    private void validateHeight(final int height, final int personCount) {
        if (height < personCount) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }
}
